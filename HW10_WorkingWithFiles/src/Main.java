public class Main {

    public static void main(String[] args) {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader("test.txt");
        FileLoggerConfiguration config = loader.load();
        FileLogger fileLogger = new FileLogger(config);
        fileLogger.debug("Hello world!");
        fileLogger.debug("Hello world!");
        fileLogger.info("info message");
    }
}

