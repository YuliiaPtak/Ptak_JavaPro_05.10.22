import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class FileLoggerConfigurationLoader {
    private String path;
    private LoggingLevel loggingLevel;
    private int sizeLimit;
    private String format;
    private boolean needToCreateNewFile;

    public FileLoggerConfiguration load(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                initialize(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new FileLoggerConfiguration(path, loggingLevel, sizeLimit, format, needToCreateNewFile);
    }

    private void initialize(String line) {
        if (line.startsWith("FILE: ")) {
            path = line.substring("FILE: ".length());
            if (!Path.of(path).toAbsolutePath().startsWith(new File("").getAbsolutePath())) {
                throw new RuntimeException("Wrong path");
            }
        } else if (line.startsWith("LEVEL: ")) {
            try {
                loggingLevel = LoggingLevel.valueOf(line.substring("LEVEL: ".length()));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Incorrect value at " + line + ", must be " + Arrays.toString(LoggingLevel.values()), e);
            }
        } else if (line.startsWith("MAX_SIZE: ")) {
            try {
                sizeLimit = Integer.parseInt(line.substring("MAX_SIZE: ".length()));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Impossible to convert " + line + " to int", e);
            }
        } else if (line.startsWith("FORMAT: ")) {
            format = line.substring("FORMAT: ".length());
        } else if (line.startsWith("NEED_TO_CREATE_NEW_FILE: ")) {
            needToCreateNewFile = Boolean.parseBoolean(line.substring("NEED_TO_CREATE_NEW_FILE: ".length()));
        } else throw new RuntimeException("Unknown configuration property at " + line);
    }
}
