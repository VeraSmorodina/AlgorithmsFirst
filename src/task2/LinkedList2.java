import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head;
        while (node != null) {
            if (count() == 1 && this.head.value == _value) {
                head = null;
                tail = null;
                return true;
            }
            if (node == this.head && node.value == _value) {
                this.head = head.next;
                this.head.prev = null;
                return true;
            }
            if (node == this.tail && node.value == _value) {
                this.tail = this.tail.prev;
                this.tail.next = null;
                return true;
            }
            if (node.value == _value) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node node = this.head;
        while (node != null) {
            if (count() == 1 && this.head.value == _value) {
                head = null;
                tail = null;
                return;
            }
            if (node == this.head && node.value == _value) {
                this.head = head.next;
                this.head.prev = null;
            } else if (node == this.tail && node.value == _value) {
                this.tail = this.tail.prev;
                this.tail.next = null;
            } else if (node.value == _value) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
            }
            node = node.next;
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        int result = 0;
        Node node = this.head;
        while (node != null) {
            result++;
            node = node.next;
        }
        return result;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null && this.head == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
            return;
        }
        if (_nodeAfter == null) {
            Node node = this.head;
            this.head = _nodeToInsert;
            _nodeToInsert.next = node;
            node.prev = _nodeToInsert;
            return;
        }
        if (_nodeAfter.next == null) {
            _nodeAfter.next = _nodeToInsert;
            this.tail = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
            return;
        }
        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.prev = _nodeAfter;
        _nodeToInsert.next.prev = _nodeToInsert;
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

