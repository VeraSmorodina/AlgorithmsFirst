package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LinkledList2Test {
    @Test
    public void findAllInEmptyListTest5() {
        LinkedList2 list = new LinkedList2();
        ArrayList<Node> nodes = list.findAll(20);
        assert nodes.size() == 0;
    }

    @Test
    public void findAllInManyElementsListTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(20));
        list.addInTail(new Node(40));
        ArrayList<Node> nodes = list.findAll(20);
        Assertions.assertEquals(2, nodes.size());
    }

    @Test
    public void findAllInOneElementListTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(10));
        ArrayList<Node> nodes = list.findAll(10);
        Assertions.assertEquals(1, nodes.size());
    }

    @Test
    public void findAllInOneElementListWithoutElementTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(10));
        ArrayList<Node> nodes = list.findAll(30);
        Assertions.assertEquals(0, nodes.size());
    }

    @Test
    public void clearTest1() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(30));
        list.clear();
        Assertions.assertEquals(0, list.count());
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
    }

    @Test
    public void countInEmptyListTest2() {
        LinkedList2 list = new LinkedList2();
        Assertions.assertEquals(0, list.count());
    }

    @Test
    public void countInOneElementListTest2() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(10));
        Assertions.assertEquals(1, list.count());
    }

    @Test
    public void countInManyElementsListTest3() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(30));
        Assertions.assertEquals(3, list.count());
    }

    @Test
    public void insertAfterInEmptyListWithNullFirstTest() {
        LinkedList2 list = new LinkedList2();
        Node node = new Node(10);
        list.insertAfter(null, node);
        Assertions.assertEquals(1, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(10, list.tail.value);
        Assertions.assertNull(node.next);
        Assertions.assertNull(node.prev);
    }

    @Test
    public void insertAfterFirstInManyElementsListTest() {
        LinkedList2 list = new LinkedList2();
        Node first = new Node(10);
        list.addInTail(first);
        list.addInTail(new Node(20));
        list.addInTail(new Node(30));
        list.insertAfter(first, new Node(40));
        Assertions.assertEquals(4, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(40, list.head.next.value);
        Assertions.assertEquals(20, list.head.next.next.value);
        Assertions.assertEquals(30, list.tail.value);

        Assertions.assertEquals(20, list.tail.prev.value);
        Assertions.assertEquals(40, list.tail.prev.prev.value);

    }

    @Test
    public void insertBeforeLastInManyElementsListTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(20));
        Node beforeLast = new Node(30);
        list.addInTail(beforeLast);
        list.addInTail(new Node(40));
        list.insertAfter(beforeLast, new Node(50));
        Assertions.assertEquals(4, list.count());
        Assertions.assertEquals(20, list.head.value);
        Assertions.assertEquals(30, list.head.next.value);
        Assertions.assertEquals(50, list.head.next.next.value);
        Assertions.assertEquals(40, list.tail.value);

        Assertions.assertEquals(50, list.tail.prev.value);
        Assertions.assertEquals(30, list.tail.prev.prev.value);
    }

    @Test
    public void insertInEndInOneElementListTest() {
        LinkedList2 list = new LinkedList2();
        Node first = new Node(10);
        list.addInTail(first);
        list.insertAfter(first, new Node(40));
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(40, list.tail.value);

        Assertions.assertEquals(10, list.tail.prev.value);
    }

    @Test
    public void insertInStartInOneElementListTest() {
        LinkedList2 list = new LinkedList2();
        Node first = new Node(10);
        list.addInTail(first);
        list.insertAfter(null, new Node(40));
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals(40, list.head.value);
        Assertions.assertEquals(10, list.tail.value);

        Assertions.assertEquals(40, list.tail.prev.value);
        Assertions.assertEquals(10, list.head.next.value);
    }

    @Test
    public void removeAllInEmptyListTest() {
        LinkedList2 list = new LinkedList2();
        list.removeAll(20);
        Assertions.assertEquals(0, list.count());
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
    }

    @Test
    public void removeAllInManyElementsListTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(20));
        list.addInTail(new Node(20));
        list.addInTail(new Node(10));
        list.removeAll(20);
        Assertions.assertEquals(1, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(10, list.tail.value);

        Assertions.assertNull(list.head.prev);
        Assertions.assertNull(list.head.next);

    }

    @Test
    public void removeAllInManyElementsListInMiddleTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(20));
        list.addInTail(new Node(20));
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.removeAll(20);
        Assertions.assertEquals(1, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(10, list.tail.value);

        Assertions.assertNull(list.head.prev);
        Assertions.assertNull(list.head.next);
    }

    @Test
    public void removeAllInOneElementListTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(20));
        list.removeAll(20);
        Assertions.assertEquals(0, list.count());
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
    }

    @Test
    public void removeInEmptyListTest1() {
        LinkedList2 list = new LinkedList2();
        list.remove(20);
        Assertions.assertEquals(0, list.count());
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
    }

    @Test
    public void removeInManyElementsListTest1() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(30));
        list.remove(20);
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(30, list.tail.value);

        Assertions.assertEquals(30, list.head.next.value);
        Assertions.assertEquals(10, list.tail.prev.value);
    }

    @Test
    public void removeInManyElementsListLastElementTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(30));
        list.remove(30);
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(20, list.tail.value);

        Assertions.assertEquals(20, list.head.next.value);
        Assertions.assertEquals(10, list.tail.prev.value);
    }

    @Test
    public void removeInManyElementsListFirstElementTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(30));
        list.remove(10);
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals(20, list.head.value);
        Assertions.assertEquals(30, list.tail.value);

        Assertions.assertEquals(30, list.head.next.value);
        Assertions.assertEquals(20, list.tail.prev.value);
    }

    @Test
    public void removeInOneElementListTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(10));
        list.remove(10);
        Assertions.assertEquals(0, list.count());
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
    }

    @Test
    public void findAllTest() {
        Node node1 = new Node(1);
        Node node11 = new Node(1);
        Node node2 = new Node(2);
        LinkedList2 list = new LinkedList2();
        list.addInTail(node1);
        list.addInTail(node11);
        list.addInTail(node2);
        list.addInTail(new Node(3));
        ArrayList<Node> nodes = list.findAll(1);
        Assertions.assertEquals(2, nodes.size());
        Assertions.assertEquals(nodes.get(0).value, node1.value);
        Assertions.assertEquals(nodes.get(1).value, node11.value);
    }

    @Test
    public void removeTest() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.remove(2);
        Assertions.assertEquals(1, list.head.value);
        Assertions.assertEquals(3, list.tail.value);

        Assertions.assertEquals(1, list.tail.prev.value);
        Assertions.assertEquals(3, list.head.next.value);

        ArrayList<Node> nodes = list.findAll(2);
        Assertions.assertEquals(0, nodes.size());
    }

    @Test
    public void countTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        Assertions.assertEquals(1, list.head.value);
    }

    @Test
    public void removeAllTest() {
        Node node1 = new Node(1);
        Node node11 = new Node(1);
        Node node3 = new Node(3);

        LinkedList2 list = new LinkedList2();
        list.addInTail(node1);
        list.addInTail(node11);
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(node3);
        list.addInTail(new Node(2));
        list.removeAll(2);


        Assertions.assertEquals(1, list.head.value);
        Assertions.assertEquals(3, list.tail.value);
        Assertions.assertEquals(1, list.head.next.value);
        Assertions.assertEquals(3, list.head.next.next.value);
        Assertions.assertNull(list.tail.next);
        Assertions.assertEquals(1, list.tail.prev.value);

        ArrayList<Node> nodes = list.findAll(2);
        Assertions.assertEquals(0, nodes.size());
    }

    @Test
    public void clearTest() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        list.clear();
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
        Assertions.assertEquals(0, list.count());
    }
}

