package task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashTableTest {
    @Test
    public void hashFunTest() {
        HashTable table = new HashTable(17, 3);
        int index = table.hashFun("avs");
        Assertions.assertEquals(7, index);
    }

    @Test
    public void seekSlotTest() {
        HashTable table = new HashTable(11, 3);
        int index = table.put("");
        int index2 = table.put("a");
        int index3 = table.put("aa");
        int index4 = table.put("s");
        int index5 = table.put("ss");
        int index6 = table.put("s");
        int index7 = table.put("");
        Assertions.assertEquals(0, index);
    }

    @Test
    public void putTest() {
        HashTable table = new HashTable(17, 3);
        int index = table.put("avs");
        Assertions.assertEquals(7, index);
    }

    @Test
    public void putReturnErrorTest() {
        HashTable table = new HashTable(5, 1);
        int index = table.put("avs");
        int index2 = table.put("ass");
        int index3 = table.put("ccc");
        int index4 = table.put("bb");
        int index5 = table.put("bb");
        int index6 = table.put("www");
        Assertions.assertEquals(0, index);
    }

    @Test
    public void find() {
        HashTable table = new HashTable(17, 3);
        table.put("avs");
        int index = table.find("avs");
        Assertions.assertEquals(7, index);
    }
}
