package logic.context;

import java.util.HashMap;

public class TestContext {
    // class element
    private HashMap<String, Object> map;

    /**
     * Constructor initialize the map element
     */
    public TestContext() {
        this.map = new HashMap<>();
    }

    /**
     * get function that returns class from the map
     * @param key
     * @return
     * @param <T>
     */
    public <T> T get(String key) {
        Object item = map.get(key);
        if (item != null) {
            return (T) item;
        } else {
            throw new IllegalArgumentException("Item not found in context");
        }
    }

    /**
     * put function that adds class to the map
     * @param key
     * @param item
     */
    public void put(String key, Object item) {
        map.put(key, item);
    }
}
