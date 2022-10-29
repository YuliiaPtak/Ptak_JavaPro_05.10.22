public class FileLoggerConfiguration {
    private final String path;
    private final LoggingLevel loggingLevel;
    private final int sizeLimit;
    private final String format;
    private final boolean needToCreateNewFile;

    public FileLoggerConfiguration(String path, LoggingLevel loggingLevel, int sizeLimit, String format, boolean needToCreateNewFile) {
        this.path = path;
        this.loggingLevel = loggingLevel;
        this.sizeLimit = sizeLimit;
        this.format = format;
        this.needToCreateNewFile = needToCreateNewFile;
    }

    public String getPath() {
        return path;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public int getSizeLimit() {
        return sizeLimit;
    }

    public String getFormat() {
        return format;
    }

    public boolean needToCreateNewFile() {
        return needToCreateNewFile;
    }
}
