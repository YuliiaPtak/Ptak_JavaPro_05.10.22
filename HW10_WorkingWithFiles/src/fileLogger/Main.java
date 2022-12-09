package fileLogger;

import logger.Logger;
import logger.LoggerConfigurationLoader;

public class Main {

    public static void main(String[] args) {
        LoggerConfigurationLoader<FileLoggerConfiguration> loader = new FileLoggerConfigurationLoader("test.properties");
        FileLoggerConfiguration config = loader.load();
        Logger fileLogger = new FileLogger(config);
        fileLogger.debug("Hello world!");
        fileLogger.debug("Hello world!");
        fileLogger.info("info message");
    }
}

