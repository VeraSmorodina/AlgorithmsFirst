package task9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NativeDictionaryTest {
    @Test
    public void isKey() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<Integer>(10, Integer.class);
        dictionary.put("first", 1);
        dictionary.put("second", 2);
        Assertions.assertTrue(dictionary.isKey("first"));
        Assertions.assertTrue(dictionary.isKey("second"));
        Assertions.assertFalse(dictionary.isKey("sdfdsg"));
    }

    @Test
    public void putTest() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<Integer>(10, Integer.class);
        dictionary.put("first", 1);
        dictionary.put("second", 2);
        Assertions.assertEquals(1, (int) dictionary.get("first"));
        Assertions.assertEquals(2, (int) dictionary.get("second"));
    }

    @Test
    public void doublePutTest() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<Integer>(10, Integer.class);
        dictionary.put("first", 1);
        dictionary.put("second", 2);
        dictionary.put("second", 1);
        Assertions.assertEquals(1, (int) dictionary.get("first"));
        Assertions.assertEquals(1, (int) dictionary.get("second"));
    }
}
