package task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
    Stack<Integer> stack;

    @BeforeEach
    public void initializeStack() {
        stack = new Stack<>();
    }

    @Test
    public void size() {
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(2, stack.size());
    }

    @Test
    public void pop() {
        stack.push(2);
        stack.push(3);
        int popElement = stack.pop();
        Assertions.assertEquals(3, popElement);
        Assertions.assertEquals(1, stack.size());
    }

    @Test
    public void push() {
        stack.push(2);
        stack.push(3);
        int popElement1 = stack.pop();
        int popElement2 = stack.pop();
        Integer popElement3 = stack.pop();
        Assertions.assertEquals(3, popElement1);
        Assertions.assertEquals(2, popElement2);
        Assertions.assertNull(popElement3);
    }

    @Test
    public void peek() {
        stack.push(2);
        stack.push(3);
        int element = stack.peek();
        Assertions.assertEquals(3, element);
        Assertions.assertEquals(2, stack.size());
    }
}

