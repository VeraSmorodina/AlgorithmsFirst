package task11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BloomFilterTest {
    @Test
    public void isValue() {
        BloomFilter bloomFilter = new BloomFilter(7);
        bloomFilter.add("0123456789");
        bloomFilter.add("1234567890");
        bloomFilter.add("2345678901");
        bloomFilter.add("3456789012");
        bloomFilter.add("4567890123");
        bloomFilter.add("5678901234");
        bloomFilter.add("6789012345");
        bloomFilter.add("7890123456");
        bloomFilter.add("8901234567");
        bloomFilter.add("9012345678");

        Assertions.assertTrue(bloomFilter.isValue("0123456789"));
        Assertions.assertTrue(bloomFilter.isValue("1234567890"));
        Assertions.assertTrue(bloomFilter.isValue("2345678901"));
        Assertions.assertTrue(bloomFilter.isValue("3456789012"));
        Assertions.assertTrue(bloomFilter.isValue("4567890123"));
        Assertions.assertTrue(bloomFilter.isValue("5678901234"));
        Assertions.assertTrue(bloomFilter.isValue("6789012345"));
        Assertions.assertTrue(bloomFilter.isValue("7890123456"));
        Assertions.assertTrue(bloomFilter.isValue("8901234567"));
        Assertions.assertTrue(bloomFilter.isValue("9012345678"));
        Assertions.assertFalse(bloomFilter.isValue("nkjn0934"));
    }

    @Test
    public void test2() {
        int result = 0;
        result |= (1<<6);
        result |= (1<<7);
        result &= ~(1<<6);
        int a = result & (1<<6);
        int b = result & (1<<7);
        System.out.println(a);
        System.out.println(b);
    }
}

