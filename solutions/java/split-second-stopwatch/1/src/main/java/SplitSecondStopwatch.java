import java.util.ArrayList;
import java.util.List;

public class SplitSecondStopwatch {

    private String state = "ready";
    private int currentLapSeconds = 0;
    private int totalSeconds = 0;
    private final List<String> previousLaps = new ArrayList<>();

    public void start() {
        if (state.equals("running")) {
            throw new IllegalStateException("cannot start an already running stopwatch");
        } else {
            state = "running";
        }
    }

    public void stop() {
        if (!state.equals("running")) {
            throw new IllegalStateException("cannot stop a stopwatch that is not running");
        } else {
            state = "stopped";
        }
    }

    public void reset() {
        if (!state.equals("stopped")) {
            throw new IllegalStateException("cannot reset a stopwatch that is not stopped");
        } else {
            state = "ready";
            currentLapSeconds = 0;
            totalSeconds = 0;
            previousLaps.clear();
        }
    }

    public void lap() {
        if (!state.equals("running")) {
            throw new IllegalStateException("cannot lap a stopwatch that is not running");
        } else {
            previousLaps.add(formatTime(currentLapSeconds));
            currentLapSeconds = 0;
        }
    }

    public String state() {
        return state;
    }

    public String currentLap() {
        return formatTime(currentLapSeconds);
    }

    public String total() {
        return formatTime(totalSeconds);
    }

    public java.util.List<String> previousLaps() {
        return previousLaps;
    }

    public void advanceTime(String timeString) {
        if (state.equals("running")) {
            int seconds = parseTime(timeString);
            currentLapSeconds += seconds;
            totalSeconds += seconds;
        }
    }

    private int parseTime(String timeString) {
        String[] parts = timeString.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    private String formatTime(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}
