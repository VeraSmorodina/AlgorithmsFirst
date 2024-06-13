package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LinkedListTest {
    @Test
    public void findAllInEmptyListTest() {
        LinkedList list = new LinkedList();
        ArrayList<Node> nodes = list.findAll(20);
        assert nodes.size() == 0;
    }

    @Test
    public void findAllInManyElementsListTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(20));
        list.addInTail(new Node(40));
        ArrayList<Node> nodes = list.findAll(20);
        Assertions.assertEquals(2, nodes.size());
    }

    @Test
    public void findAllInOneElementListTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(10));
        ArrayList<Node> nodes = list.findAll(10);
        Assertions.assertEquals(1, nodes.size());
    }

    @Test
    public void findAllInOneElementListWithoutElementTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(10));
        ArrayList<Node> nodes = list.findAll(30);
        Assertions.assertEquals(0, nodes.size());
    }

    @Test
    public void clearTest1() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(30));
        list.clear();
        Assertions.assertEquals(0, list.count());
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
    }

    @Test
    public void countInEmptyListTest() {
        LinkedList list = new LinkedList();
        Assertions.assertEquals(0, list.count());
    }

    @Test
    public void countInOneElementListTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(10));
        Assertions.assertEquals(1, list.count());
    }

    @Test
    public void countInManyElementsListTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(30));
        Assertions.assertEquals(3, list.count());
    }

    @Test
    public void insertAfterInEmptyListWithNullFirstTest() {
        LinkedList list = new LinkedList();
        list.insertAfter(null, new Node(10));
        Assertions.assertEquals(1, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(10, list.tail.value);
    }

    @Test
    public void insertAfterFirstInManyElementsListTest() {
        LinkedList list = new LinkedList();
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
    }

    @Test
    public void insertBeforeLastInManyElementsListTest() {
        LinkedList list = new LinkedList();
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
    }

    @Test
    public void insertInEndInOneElementListTest() {
        LinkedList list = new LinkedList();
        Node first = new Node(10);
        list.addInTail(first);
        list.insertAfter(first, new Node(40));
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(40, list.tail.value);
    }

    @Test
    public void insertInStartInOneElementListTest() {
        LinkedList list = new LinkedList();
        Node first = new Node(10);
        list.addInTail(first);
        list.insertAfter(null, new Node(40));
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals(40, list.head.value);
        Assertions.assertEquals(10, list.tail.value);
    }

    @Test
    public void removeAllInEmptyListTest() {
        LinkedList list = new LinkedList();
        list.removeAll(20);
        Assertions.assertEquals(0, list.count());
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
    }

    @Test
    public void removeAllInManyElementsListTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(20));
        list.addInTail(new Node(20));
        list.addInTail(new Node(10));
        list.removeAll(20);
        Assertions.assertEquals(1, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(10, list.tail.value);
    }

    @Test
    public void removeAllInManyElementsListInMiddleTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(20));
        list.addInTail(new Node(20));
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.removeAll(20);

        Assertions.assertEquals(1, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(10, list.tail.value);
        Assertions.assertNull(list.tail.next);
    }

    @Test
    public void removeAllInOneElementListTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(20));
        list.removeAll(20);
        Assertions.assertEquals(0, list.count());
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
    }

    @Test
    public void removeInEmptyListTest() {
        LinkedList list = new LinkedList();
        list.remove(20);
        Assertions.assertEquals(0, list.count());
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
    }

    @Test
    public void removeInManyElementsListTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(30));
        list.remove(20);
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(30, list.tail.value);
    }

    @Test
    public void removeInManyElementsListLastElementTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(30));
        list.remove(30);
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals(10, list.head.value);
        Assertions.assertEquals(20, list.tail.value);
    }

    @Test
    public void removeInManyElementsListFirstElementTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(10));
        list.addInTail(new Node(20));
        list.addInTail(new Node(30));
        list.remove(10);
        Assertions.assertEquals(2, list.count());
        Assertions.assertEquals(20, list.head.value);
        Assertions.assertEquals(30, list.tail.value);
    }

    @Test
    public void removeInOneElementListTest() {
        LinkedList list = new LinkedList();
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
        LinkedList list = new LinkedList();
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
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.remove(2);
        Assertions.assertEquals(node3, node1.next);
        ArrayList<Node> nodes = list.findAll(2);
        Assertions.assertEquals(0, nodes.size());
    }

    @Test
    public void countTest() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        Assertions.assertEquals(5, list.count());
    }

    @Test
    public void removeAllTest() {
        Node node1 = new Node(1);
        Node node11 = new Node(1);
        Node node3 = new Node(3);

        LinkedList list = new LinkedList();
        list.addInTail(node1);
        list.addInTail(node11);
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(node3);
        list.addInTail(new Node(2));

        list.removeAll(2);
        Assertions.assertEquals(node3, node11.next);
        Assertions.assertNull(node3.next);
        ArrayList<Node> nodes = list.findAll(2);
        Assertions.assertEquals(0, nodes.size());
    }

    @Test
    public void clearTest() {
        LinkedList list = new LinkedList();
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

    @Test
    public void insertAfterTest7() {
        LinkedList listRes = new LinkedList();
        listRes.addInTail(new Node(1));
        listRes.addInTail(new Node(2));
        listRes.addInTail(new Node(3));
        listRes.addInTail(new Node(4));

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(node2);
        list.addInTail(node3);
        list.insertAfter(node2, node4);
        Assertions.assertEquals(node2.next, node4);
        Assertions.assertEquals(node4.next, node3);
    }
}

