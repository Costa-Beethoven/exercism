public class LogLine {

    private final String abbreviation;
    private final String message;

    public LogLine(String logLine) {
        this.abbreviation = logLine.substring(logLine.indexOf("[")+1, logLine.indexOf("]"));

        int messageIndex = logLine.indexOf(":")+2;
        this.message = logLine.substring(messageIndex);
    }

    public LogLevel getLogLevel() {
        return switch (this.abbreviation) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };
    }

    public String getOutputForShortLog() {
        return getLogLevel().getShortOutput() + ":" + this.message;
    }
}
