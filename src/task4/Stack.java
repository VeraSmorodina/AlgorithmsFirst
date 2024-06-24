import java.util.*;

public class Stack<T> {
    private final ArrayList<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public T pop() {
        if (list.size() == 0) return null;
        T val = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return val;
    }

    public void push(T val) {
        list.add(val);
    }

    public T peek() {
        if (list.size() == 0) return null;
        T val = list.get(list.size() - 1);
        return val;
    }
}

