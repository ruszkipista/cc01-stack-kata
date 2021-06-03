package stack;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StackTest {
    @Test
    public void createStack() throws Exception {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
    }
}
