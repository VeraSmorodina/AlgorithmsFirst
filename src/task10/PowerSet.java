public class PowerSet {

    private final HashTable hashTable;

    public PowerSet() {
        hashTable = new HashTable(20000, 1);
    }

    public int size() {
        int sum = 0;
        for (String slot : hashTable.slots) {
            if (slot != null)
                sum++;
        }
        return sum;
    }

    public void put(String value) {
        if (hashTable.find(value) == -1)
            hashTable.put(value);
    }

    public boolean get(String value) {
        return hashTable.find(value) != -1;
    }

    public boolean remove(String value) {
        int index = hashTable.find(value);
        if (index == -1)
            return false;
        hashTable.slots[index] = null;
        return true;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet result = new PowerSet();
        if (size() == 0 || set2.size() == 0) return result;
        for (String slot : hashTable.slots) {
            if (set2.get(slot))
                result.put(slot);
        }
        return result;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet result = new PowerSet();
        if (size() == 0 && set2.size() == 0)
            return result;
        if (size() == 0)
            return set2;
        if (set2.size() == 0)
            return this;
        for (String slot : hashTable.slots) {
            if (slot != null)
                result.put(slot);
        }
        for (String slot : set2.hashTable.slots) {
            if (slot != null)
                result.put(slot);
        }
        return result;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet result = new PowerSet();
        for (String slot : hashTable.slots) {
            if (slot != null && !set2.get(slot))
                result.put(slot);
        }
        return result;
    }

    public boolean isSubset(PowerSet set2) {
        for (String slot : set2.hashTable.slots) {
            if (slot != null && !get(slot))
                return false;
        }
        return true;
    }

    private static class HashTable {
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
                if (hash + step >= slots.length && nextIteration) {
                    return -1;
                }
            }
            return hash;
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
}

