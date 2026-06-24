public class LogLevels {
    
    public static String message(String logLine) {
        int colonIndex = logLine.indexOf(":");
        String newLogLine = logLine.substring(colonIndex + 1);
        return newLogLine.trim();
    }

    public static String logLevel(String logLine) {
        return (logLine.substring(logLine.indexOf("[") + 1, logLine.indexOf("]"))).toLowerCase();
    }

    public static String reformat(String logLine) {
        String msg = message(logLine);
        String level = logLevel(logLine);
        return msg + " (" + level + ")";
    }
}
