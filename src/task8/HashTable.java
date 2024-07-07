package task8;

public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        int sum = 0;
        byte[] bytes = value.getBytes();
        for (byte aByte : bytes) {
            sum += aByte;
        }
        return sum % size;
    }

    public int seekSlot(String value) {
        int hashStep = step;
        int hash = hashFun(value);
        return seekSlotRecursive(value, hash, hashStep, false);
    }

    private int seekSlotRecursive(String value, int hash, int hashStep, boolean nextIteration) {
        if (slots[hash] == null) {
            return hash;
        }
        hash += hashStep;
        if (hash >= slots.length) {
            hash = hash - slots.length;
            nextIteration = true;
            hashStep *= 2;
        }
        if (nextIteration && hash > hashFun(value)) {
            return -1;
        }
        if (hash + step >= slots.length && nextIteration) {
            return -1;
        }
        return seekSlotRecursive(value, hash, hashStep, nextIteration);
    }

    public int put(String value) {
        int index = seekSlot(value);
        if (index == -1) return -1;
        slots[index] = value;
        return index;
    }

    public int find(String value) {
        int index = -1;
        for (int i = 0; i < slots.length; i++) {
            String slot = slots[i];
            if (slot != null && slot.equals(value)) return i;
        }
        return index;
    }
}

