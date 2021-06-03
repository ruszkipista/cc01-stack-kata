package stack;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackTest {
    @Test
    public void newlyCreatedStack_ShouldBeEmpty() throws Exception {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        assertEquals(0,stack.getSize());
    }
    
    @Test
    public void afterOnePush_SizeShouldBeOne() throws Exception {
        Stack stack = new Stack();
        stack.push(1);
        assertEquals(1,stack.getSize());
    }
    
}
