package task4;

import java.util.ArrayList;

public class Queue<T> {
    private final ArrayList<T> elements;

    public Queue() {
        elements = new ArrayList<>();
    }

    public void push(T item) {
        elements.add(0, item);
    }

    public T pop() {
        if (size() == 0) return null;
        T element = elements.get(0);
        elements.remove(0);
        return element;
    }

    public T peek() {
        if (elements.size() == 0) return null;
        T val = elements.get(0);
        return val;
    }

    public int size() {
        return elements.size();
    }
}

