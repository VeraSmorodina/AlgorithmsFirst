package task7;

import java.util.*;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        if (v1.getClass() == Integer.class && v2.getClass() == Integer.class) {
            Integer first = (Integer) v1;
            Integer second = (Integer) v2;
            return Integer.compare(first - second, 0);
        }
        if (v1.getClass() == String.class && v2.getClass() == String.class) {
            String first = ((String) v1).trim();
            String second = ((String) v2).trim();
            return first.compareTo(second);
        }
        return 0;
    }

    public void add(T value) {
        Node<T> nodeToInsert = new Node<>(value);
        Node<T> node = this.head;
        if (head == null) {
            head = nodeToInsert;
            tail = nodeToInsert;
            return;
        }
        while (node != null) {
            int compareResult = compare(value, node.value);
            boolean compareResultWithAscending = (_ascending && compareResult > 0 || !_ascending && compareResult < 0);
            if (node == head && !compareResultWithAscending) {
                head = nodeToInsert;
                head.next = node;
                node.prev = nodeToInsert;
                return;
            }
            if (!compareResultWithAscending) {
                Node<T> nodePrev = node.prev;
                node.prev.next = nodeToInsert;
                nodeToInsert.prev = nodePrev;
                nodeToInsert.next = node;
                node.prev = nodeToInsert;
                return;
            }
            if (node == tail) {
                node.next = nodeToInsert;
                nodeToInsert.prev = node;
                tail = nodeToInsert;
                return;
            }
            node = node.next;
        }
        // автоматическая вставка value
        // в нужную позицию
    }

    public Node<T> find(T val) {
        Node<T> node = this.head;
        while (node != null) {
            if (node.value == val) {
                return node;
            }
            if (_ascending && compare(node.value, val) >= 0) {
                return null;
            }
            if (!_ascending && compare(node.value, val) <= 0) {
                return null;
            }
            node = node.next;
        }
        return null; // здесь будет ваш код
    }

    public void delete(T val) {
        Node<T> node = head;
        while (node != null) {
            if (count() == 1 && node.value == val) {
                head = null;
                tail = null;
                return;
            }
            if (head.value == val) {
                head = node.next;
                head.prev = null;
                return;
            }
            if (tail.value == val) {
                tail = tail.prev;
                tail.next = null;
                return;
            }
            if (node.value == val) {
                Node<T> prev = node.prev;
                Node<T> next = node.next;
                prev.next = next;
                next.prev = prev;
                return;
            }
            node = node.next;
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        head = null;
        tail = null;
    }

    public int count() {
        int sum = 0;
        Node<T> node = head;
        while (node != null) {
            sum += 1;
            node = node.next;
        }
        return sum;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}

