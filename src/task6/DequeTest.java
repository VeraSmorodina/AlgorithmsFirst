package task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DequeTest {
    @Test
    public void palindrom() {
        String s = "lol";
        Deque<Character> deque = new Deque<>();
        char[] chars = s.toCharArray();
        char[] chars2 = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            deque.addFront(chars[i]);
        }
        int dequeSize = deque.size();
        for (int i = 0; i < dequeSize; i++) {
            chars2[i] = deque.removeTail();
        }
        Assertions.assertArrayEquals(chars, chars2);
    }
}
