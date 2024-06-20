package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DynArrayTest {
    @Test
    public void appendInEmptyArrayTest() {
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.append(5);
        array.append(10);
        Assertions.assertEquals(2, array.count);
        Assertions.assertEquals(16, array.capacity);
        Assertions.assertEquals(16, array.array.length);
    }

    @Test
    public void appendInFullArrayTest() {
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 20; i++) {
            array.append(i);
        }
        Assertions.assertEquals(20, array.count);
        Assertions.assertEquals(32, array.capacity);
    }

    @Test
    public void createArray() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        Assertions.assertEquals(16, dynArray.array.length);
        Assertions.assertEquals(0, dynArray.count);
        Assertions.assertEquals(16, dynArray.capacity);
        Assertions.assertEquals(Integer.class, dynArray.clazz);
    }

    @Test
    public void getItemInEmptyListTest() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        Integer item = dynArray.getItem(0);
        Assertions.assertNull(item);
    }

    @Test
    public void getItemExceptionTest() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> dynArray.getItem(20));
    }

    @Test
    public void getItemNormalTestInOneElementArray() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(6);
        Integer item = dynArray.getItem(0);
        Assertions.assertEquals(6, item);
    }

    @Test
    public void getItemNormalTestInMAnyElementsArray() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(6);
        dynArray.append(9);
        dynArray.append(8);
        Integer item = dynArray.getItem(1);
        Assertions.assertEquals(9, item);
    }

    @Test
    public void insertInEmptyListTest() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.insert(5, 0);
        Assertions.assertEquals(16, dynArray.array.length);
        Assertions.assertEquals(1, dynArray.count);
        Assertions.assertEquals(16, dynArray.capacity);
        Assertions.assertEquals(5, dynArray.getItem(0));
    }

    @Test
    public void insertInManyElementsListTest() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(2);
        dynArray.append(4);
        dynArray.append(8);
        dynArray.insert(6, 1);
        Assertions.assertEquals(16, dynArray.array.length);
        Assertions.assertEquals(4, dynArray.count);
        Assertions.assertEquals(16, dynArray.capacity);
        Assertions.assertEquals(2, dynArray.getItem(0));
        Assertions.assertEquals(6, dynArray.getItem(1));
        Assertions.assertEquals(4, dynArray.getItem(2));
        Assertions.assertEquals(8, dynArray.getItem(3));
    }

    @Test
    public void insertExceptionTest() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(2);
        dynArray.append(4);
        dynArray.append(8);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> dynArray.insert(6, 10));
    }

    @Test
    public void insertWithIncreaseElementsTest() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.append(8);
        dynArray.insert(90, 16);
        Assertions.assertEquals(32, dynArray.array.length);
        Assertions.assertEquals(17, dynArray.count);
        Assertions.assertEquals(32, dynArray.capacity);
        Assertions.assertEquals(90, dynArray.getItem(16));
    }

    @Test
    public void insertWithIncreaseElementsTest2() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            dynArray.append(i);
        }
        dynArray.insert(90, 15);
        Assertions.assertEquals(17, dynArray.count);
        Assertions.assertEquals(32, dynArray.capacity);
        Assertions.assertEquals(90, dynArray.getItem(15));
        Assertions.assertEquals(15, dynArray.getItem(16));
    }

    @Test
    public void makeNewArrayTest() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.makeArray(30);
        Assertions.assertEquals(30, dynArray.array.length);
        Assertions.assertEquals(0, dynArray.count);
        Assertions.assertEquals(30, dynArray.capacity);
    }

    @Test
    public void test_remove_standard_case() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(1);
        dynArray.append(2);
        dynArray.append(3);
        dynArray.remove(1);
        Assertions.assertEquals(2, dynArray.count);
        Assertions.assertEquals(16, dynArray.capacity);
        Assertions.assertEquals(1, dynArray.getItem(0));
        Assertions.assertEquals(3, dynArray.getItem(1));
    }

    @Test
    public void test_remove_standard_case_last_element() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(1);
        dynArray.append(2);
        dynArray.append(3);
        dynArray.remove(2);
        Assertions.assertEquals(2, dynArray.count);
        Assertions.assertEquals(16, dynArray.capacity);
        Assertions.assertEquals(1, dynArray.getItem(0));
        Assertions.assertEquals(2, dynArray.getItem(1));
    }

    @Test
    public void test_remove_standard_case_middle_element() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(1);
        dynArray.append(2);
        dynArray.append(3);
        dynArray.append(4);
        dynArray.append(5);
        dynArray.remove(1);
        Assertions.assertEquals(4, dynArray.count);
        Assertions.assertEquals(16, dynArray.capacity);
        Assertions.assertEquals(1, dynArray.getItem(0));
        Assertions.assertEquals(3, dynArray.getItem(1));
        Assertions.assertEquals(4, dynArray.getItem(2));
        Assertions.assertEquals(5, dynArray.getItem(3));
    }

    @Test
    public void test_remove_first_element() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(1);
        dynArray.append(4);
        dynArray.remove(0);
        Assertions.assertEquals(1, dynArray.count);
        Assertions.assertEquals(16, dynArray.capacity);
        Assertions.assertEquals(4, dynArray.getItem(0));
    }

    @Test
    public void test_remove_in_empty_list_exception_case() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> dynArray.remove(17));
    }

    @Test
    public void test_remove_in_empty_list() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> dynArray.remove(0));
    }

    @Test
    public void test_remove_one_element() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(9);
        dynArray.remove(0);
        Assertions.assertEquals(0, dynArray.count);
        Assertions.assertEquals(16, dynArray.capacity);
    }

    @Test
    public void test_remove_with_decreasing() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 30; i++) {
            dynArray.append(i);
        }
        for (int i = 0; i < 15; i++) {
            dynArray.remove(i);
        }
        Assertions.assertEquals(15, dynArray.count);
        Assertions.assertEquals(21, dynArray.capacity);
    }

    @Test
    public void test_remove_with_minimal_size() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            dynArray.append(i);
        }
        dynArray.remove(15);
        Assertions.assertEquals(15, dynArray.count);
        Assertions.assertEquals(16, dynArray.capacity);
    }

    @Test
    public void test_remove_with_decreasing_to_minimal_size() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 17; i++) {
            dynArray.append(i);
        }
        for (int i = 0; i < 9; i++) {
            dynArray.remove(i);
        }
        Assertions.assertEquals(8, dynArray.count);
        Assertions.assertEquals(16, dynArray.capacity);
    }

    @Test
    public void test_remove_all() {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            dynArray.append(i);
        }
        for (int i = 0; i < 16; i++) {
            dynArray.remove(0);
        }
        Assertions.assertEquals(0, dynArray.count);
        Assertions.assertEquals(16, dynArray.capacity);
    }
}

