package task12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NativeCacheTest {
    @Test
    public void put() {
        NativeCache<Integer> cache = new NativeCache<Integer>(3, Integer.class);
        cache.put("first", 1);
        cache.put("second", 2);
        cache.get("first");
        cache.get("second");
        cache.get("second");
        cache.put("third", 3);
        cache.put("last", 4);
        Assertions.assertEquals(1, (int) cache.get("first"));
        Assertions.assertEquals(4, (int) cache.get("last"));
        Assertions.assertEquals(2, (int) cache.get("second"));
        Assertions.assertNull(cache.get("third"));
    }
}

