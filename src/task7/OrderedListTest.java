package task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderedListTest {
    @Test
    public void compareTest() {
        OrderedList<Integer> list = new OrderedList<>(true);
        int result = list.compare(1, 2);
        int assertedResult = -1;
        Assertions.assertEquals(result, assertedResult);
    }

    @Test
    public void deleteTest() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(1);
        list.add(2);
        list.add(3);
        list.delete(3);
        Assertions.assertEquals(2, (int) list.getAll().get(0).value);
        Assertions.assertEquals(1, (int) list.getAll().get(1).value);
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals(2, (int) list.head.value);
        Assertions.assertEquals(1, (int) list.tail.value);
    }

    @Test
    public void findTest() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(1);
        list.add(2);
        list.add(3);
        Node<Integer> founded = list.find(1);
        Node<Integer> notFounded = list.find(8);
        Assertions.assertEquals(1, (int) founded.value);
        Assertions.assertNull(notFounded);
    }

    @Test
    public void clearTest() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear(true);
        Assertions.assertNull(list.head);
    }



//
@Test
public void addOneElementTest() {
    OrderedList<Integer> list = new OrderedList<Integer>(true);
    list.add(5);
    Assertions.assertEquals(5, (int) list.getAll().get(0).value);
    Assertions.assertEquals(1, list.count());
    Assertions.assertEquals(5, (int) list.head.value);
    Assertions.assertEquals(5, (int) list.tail.value);
}

    @Test
    public void checkAscendingTest() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(0);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(0);
        Assertions.assertEquals(0, (int) list.head.value);
        Assertions.assertEquals(7, list.count());
        Assertions.assertEquals(2, (int) list.tail.value);
        Assertions.assertNull(list.tail.next);
        Assertions.assertNull(list.head.prev);
    }

    @Test
    public void checkAscendingTest2() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(0);
        list.add(-7);
        list.add(0);
        Assertions.assertEquals(-7, (int) list.head.value);
        Assertions.assertEquals(0, (int) list.head.next.value);
        Assertions.assertEquals(0, (int) list.head.next.next.value);
        Assertions.assertEquals(3, list.count());
        Assertions.assertEquals(0, (int) list.tail.value);
    }

    @Test
    public void checkAscendingStringsTest() {
        OrderedList<String> list = new OrderedList<String>(true);
        list.add("b");
        list.add("A");
        Assertions.assertEquals("A", list.head.value);
        Assertions.assertEquals("b", list.head.next.value);
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals("b", list.tail.value);
    }

    @Test
    public void checkInvertedAscendingStringsTest() {
        OrderedList<String> list = new OrderedList<String>(true);
        list.add(" zz");
        list.add("ui");
        list.add(" aa");
        Assertions.assertEquals(" zz", list.getAll().get(2).value);
        Assertions.assertEquals("ui", list.getAll().get(1).value);
        Assertions.assertEquals(" aa", list.getAll().get(0).value);
        Assertions.assertEquals(3, list.count());
        Assertions.assertEquals(" zz", list.tail.value);
        Assertions.assertEquals(" aa", list.head.value);
    }

    @Test
    public void checkInvertedAscendingTest() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);
        list.add(5);
        list.add(3);
        list.add(7);
        Assertions.assertEquals(7, (int) list.getAll().get(0).value);
        Assertions.assertEquals(5, (int) list.getAll().get(1).value);
        Assertions.assertEquals(3, (int) list.getAll().get(2).value);
        Assertions.assertEquals(3, list.count());
        Assertions.assertEquals(7, (int) list.head.value);
        Assertions.assertEquals(3, (int) list.tail.value);
    }
}
