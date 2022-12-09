package fileLogger;

import logger.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss.SSS");
    private final FileLoggerConfiguration config;

    private String path;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
        path = buildFilePath();
    }

    @Override
    public void debug(String message) {
        if (config.getLoggingLevel().equals(LoggingLevel.INFO)) {
            return;
        }
        log(buildMessage(message, LoggingLevel.DEBUG));
    }

    @Override
    public void info(String message) {
        log(buildMessage(message, LoggingLevel.INFO));
    }

    private String buildFilePath() {
        return config.getPath() + "_" + FORMATTER.format(LocalDateTime.now());
    }

    private String buildMessage(String message, LoggingLevel level) {
        return String.format(config.getFormat(), FORMATTER.format(LocalDateTime.now()), level.name(), message);
    }

    private void log(String message) {
        long messageSize = message.getBytes().length;
        if (messageSize > config.getSizeLimit()) {
            throw new RuntimeException("Message is too large");
        }

        File file = getFile();
        if (file.length() + messageSize < config.getSizeLimit()) {
            write(file, message);
        } else if (config.needToCreateNewFile()) {
            path = buildFilePath();
            write(getFile(), message);
        } else throw new RuntimeException("File size is exceeded");
    }

    private void write(File file, String message) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write message", e);
        }
    }

    private File getFile() {
        File file = new File(path);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            throw new RuntimeException("Failed to create file", e);
        }
    }
}
