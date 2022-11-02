import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Properties;

public class FileLoggerConfigurationLoader {
    private final String path;

    public FileLoggerConfigurationLoader(String path) {
        this.path = path;
    }

    public FileLoggerConfiguration load() {
        Properties properties = getProperties(path);

        String fileName = getProperty(properties, "FILE");
        String level = getProperty(properties, "LEVEL");
        String maxSize = getProperty(properties, "MAX_SIZE");
        String format = getProperty(properties, "FORMAT");
        String needToCreateNewFile = getProperty(properties, "NEED_TO_CREATE_NEW_FILE");

        this.validateValues(fileName, level, maxSize);
        return new FileLoggerConfiguration(fileName, LoggingLevel.valueOf(level), Integer.parseInt(maxSize), format, Boolean.parseBoolean(needToCreateNewFile));
    }

    private void validateValues(String fileName, String level, String maxSize) {
        if (!Path.of(fileName).toAbsolutePath().startsWith((new File("")).getAbsolutePath())) {
            throw new RuntimeException("Path is not within project directory");
        }

        try {
            LoggingLevel.valueOf(level);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Incorrect value at " + level + ", must be " + Arrays.toString(LoggingLevel.values()), e);
        }

        try {
            Integer.parseInt(maxSize);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Impossible to convert " + maxSize + " to int", e);
        }
    }

    private String getProperty(Properties properties, String key) {
        String property = properties.getProperty(key);
        if (property != null && !property.isBlank()) {
            return property;
        } else {
            throw new RuntimeException("No property " + key);
        }
    }

    private Properties getProperties(String path) {
        Properties properties = new Properties();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
            properties.load(bufferedReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
