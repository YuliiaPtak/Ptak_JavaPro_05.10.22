import fileLogger.FileLogger;
import fileLogger.FileLoggerConfigurationLoader;
import logger.Logger;

public class LoggerService {

    private static LoggerService instance;
    private final Logger logger;

    private LoggerService() {
        logger = new FileLogger(new FileLoggerConfigurationLoader("src/main/resources/config.properties").load());
    }

    public static LoggerService getInstance() {
        if (instance == null) {
            init();
        }
        return instance;
    }

    private static synchronized void init() {
        if (instance == null) {
            instance = new LoggerService();
        }
    }

    public void info(String s) {
        logger.info(s);
    }

    public void debug(String s) {
        logger.debug(s);
    }
}
