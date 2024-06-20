import java.lang.reflect.Array;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    @SuppressWarnings({"rawtypes"})
    Class clazz;

    @SuppressWarnings({"rawtypes"})
    public DynArray(Class clz) {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    @SuppressWarnings({"unchecked"})
    public void makeArray(int new_capacity) {
        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
        if (array != null && new_capacity > capacity) {
            System.arraycopy(array, 0, newArray, 0, capacity);
        }
        if (array != null && new_capacity < capacity) {
            System.arraycopy(array, 0, newArray, 0, new_capacity);
        }
        array = newArray;
        capacity = new_capacity;
    }

    public T getItem(int index) {
        if (index >= 0 && index < capacity) {
            return array[index];
        } else throw new IndexOutOfBoundsException();
    }

    public void append(T itm) {
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        for (int i = 0; i < capacity; i++) {
            if (array[i] == null) {
                array[i] = itm;
                count += 1;
                return;
            }
        }
    }

    public void insert(T itm, int index) {
        if (index > capacity || index > count || index < 0) throw new IndexOutOfBoundsException();
        if (count == capacity) makeArray(capacity * 2);
        if (index == count) {
            append(itm);
            return;
        }
        if (index < count) {
            moveArrayToEnd(index);
            array[index] = itm;
            count += 1;
        }
    }

    public void remove(int index) {
        if (index >= capacity || index >= count || index < 0) throw new IndexOutOfBoundsException();
        count -= 1;
        array[index] = null;
        moveArrayToStart();
        if (count < capacity / 2 && capacity > 16) {
            makeArray((int) (capacity / 1.5 >= 16 ? capacity / 1.5 : 16));
        }
    }

    @SuppressWarnings("unchecked")
    private void moveArrayToStart() {
        T[] newArray = (T[]) Array.newInstance(this.clazz, array.length);
        int newArrayIndex = 0;
        for (T t : array) {
            if (t != null) {
                newArray[newArrayIndex] = t;
                newArrayIndex += 1;
            }
        }
        array = newArray;
    }

    @SuppressWarnings({"unchecked"})
    private void moveArrayToEnd(int fromIndex) {
        T[] newArray = (T[]) Array.newInstance(this.clazz, capacity);
        if (capacity - 1 - fromIndex >= 0)
            System.arraycopy(array, fromIndex, newArray, fromIndex + 1, capacity - 1 - fromIndex);
        if (fromIndex >= 0) System.arraycopy(array, 0, newArray, 0, fromIndex);
        array = newArray;
    }
}

