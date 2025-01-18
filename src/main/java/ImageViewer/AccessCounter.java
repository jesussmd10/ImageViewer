package ImageViewer;

import java.util.concurrent.ConcurrentHashMap;

public class AccessCounter {

    private static final AccessCounter INSTANCE = new AccessCounter();
    private final ConcurrentHashMap<String, Integer> accesses = new ConcurrentHashMap<>();

    private AccessCounter() {}

    public static AccessCounter getInstance() {
        return INSTANCE;
    }

    public int increment(String key) {
        return accesses.merge(key, 1, Integer::sum);
    }
}
