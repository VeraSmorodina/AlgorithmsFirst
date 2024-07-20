public class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;

    public NativeCache(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        hits = new int[sz];
    }

    public int hashFun(String key) {
        int sum = 0;
        byte[] bytes = key.getBytes();
        for (byte aByte : bytes)
            sum += aByte;
        return sum % size;
    }

    public boolean isKey(String key) {
        for (String slot : slots) {
            if (slot != null && slot.equals(key))
                return true;
        }
        return false;
    }

    public void put(String key, T value) {
        if (checkFillSlots()) {
            removeElement();
        }
        int index = hashFun(key);
        if (slots[index] != null) {
            index = seekSlot(key);
        }
        slots[index] = key;
        values[index] = value;
    }

    private boolean checkFillSlots() {
        for (String slot : slots) {
            if (slot == null) return false;
        }
        return true;
    }

    public T get(String key) {
        if (!isKey(key))
            return null;
        int index = 0;
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != null && slots[i].equals(key)) {
                index = i;
                break;
            }
        }
        hits[index]++;
        return values[index];
    }

    private void removeElement() {
        int hitsCount = hits[0];
        int minHitIndex = 0;
        for (int i = 1; i < hits.length; i++) {
            if (hits[i] < hitsCount) {
                hitsCount = hits[i];
                minHitIndex = i;
            }
        }
        values[hashFun(slots[minHitIndex])] = null;
        slots[minHitIndex] = null;
        hits[minHitIndex] = 0;
    }

    private int seekSlot(String value) {
        int hashStep = 1;
        int hash = hashFun(value);
        if (slots[hash] == null) {
            return hash;
        }
        boolean nextIteration = false;
        while (slots[hash] != null) {
            hash += hashStep;
            if (hash >= slots.length) {
                hash = hash - slots.length;
                nextIteration = true;
                hashStep *= 2;
            }
            if (nextIteration && hash > hashFun(value)) {
                return -1;
            }
            if (hash + 1 >= slots.length && nextIteration) {
                return -1;
            }
        }
        return hash;
    }
}

