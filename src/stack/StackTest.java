package stack;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackTest {
    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
    }
    
    @Test
    public void newlyCreatedStack_ShouldBeEmpty() throws Exception {
        assertTrue(stack.isEmpty());
        assertEquals(0,stack.getSize());
    }
    
    @Test
    public void afterOnePush_SizeShouldBeOne() throws Exception {
        stack.push(1);
        assertEquals(1,stack.getSize());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void afterOnePushAndOnePop_ShouldBeEmpty() throws Exception {
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }
    
}
