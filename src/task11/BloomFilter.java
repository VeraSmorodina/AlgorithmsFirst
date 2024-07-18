public class BloomFilter {
    public int filter_len;
    private int bitInt;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        bitInt = 0;
    }

    public int hash1(String str1) {
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = (result * 17 + code) % filter_len;
        }
        return result;
    }

    public int hash2(String str1) {
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = (result * 223 + code) % filter_len;
        }
        return result;
    }

    public void add(String str1) {
        int index1 = hash1(str1);
        int index2 = hash2(str1);
        bitInt |= (1 << index1);
        bitInt |= (1 << index2);

    }

    public boolean isValue(String str1) {
        int index1 = hash1(str1);
        int index2 = hash2(str1);

        return (bitInt & (1 << index1)) != 0 && (bitInt & (1 << index2)) != 0;
    }
}

