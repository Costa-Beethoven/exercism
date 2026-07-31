import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter<K> {

    int limit;
    private final Duration windowSize;
    private final TimeSource timeSource;
    private final Map<K, ClientRequests> clients = new HashMap<>();

    private static class ClientRequests {
        int remainingRequests;
        Instant windowStart;

        ClientRequests(int remainingRequests, Instant windowStart) {
            this.remainingRequests = remainingRequests;
            this.windowStart = windowStart;
        }
    }

    public RateLimiter(int limit, Duration windowSize, TimeSource timeSource) {
        this.limit = limit;
        this.windowSize = windowSize;
        this.timeSource = timeSource;
    }

    public boolean allow(K clientId) {

        Instant now = timeSource.now();
        ClientRequests client = clients.computeIfAbsent(clientId, k -> new ClientRequests(limit, now));

        if (!now.isBefore(client.windowStart.plus(windowSize))) {
            client.remainingRequests = limit;
            client.windowStart = now;
        }

        if (client.remainingRequests <= 0) {
            return false;
        }

        client.remainingRequests--;
        return true;
    }
}
