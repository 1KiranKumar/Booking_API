package Utilities;

import java.util.HashMap;
import java.util.Map;

public class GlobalContext {
    private static final Map<String, Object> session = new HashMap<>();

    public static void put(String key, Object value) {
        session.put(key, value);
    }

    public static Object get(String key) {
        return session.get(key);
    }
}
