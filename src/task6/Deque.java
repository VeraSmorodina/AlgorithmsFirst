package task6;

import java.util.*;

public class Deque<T> {
    private final LinkedList<T> elements;

    public Deque() {
        elements = new LinkedList<>();
    }

    public void addFront(T item) {
        elements.add(0, item);
    }

    public void addTail(T item) {
        elements.add(item);
    }

    public T removeFront() {
        if (size() == 0) return null;
        T element = elements.get(0);
        elements.remove(element);
        return element;
    }

    public T removeTail() {
        if (size() == 0) return null;
        T element = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return element;
    }

    public int size() {
        return elements.size();
    }
}

