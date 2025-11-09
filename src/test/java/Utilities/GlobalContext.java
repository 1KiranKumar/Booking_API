package Utilities;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class GlobalContext {
    private static final Map<String, Object> session = new HashMap<>();
    public Response res;

    public static void put(String key, Object value) {
        session.put(key, value);
    }

    public static Object get(String key) {
        return session.get(key);
    }
}
