import java.util.*;

public class Queue<T> {
    private final ArrayList<T> elements;

    public Queue() {
        elements = new ArrayList<>();
    }

    public void enqueue(T item) {
        elements.add(item);
    }

    public T dequeue() {
        if (size() == 0) return null;
        T elem = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return elem;
    }

    public int size() {
        return elements.size();
    }
}

