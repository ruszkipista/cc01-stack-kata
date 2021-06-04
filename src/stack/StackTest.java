package stack;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class StackTest {
    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = Stack.Make(2);
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

    @Test(expected = Stack.Overflow.class)
    public void whenPushedPastLimit_StackOverflows() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test(expected = Stack.Underflow.class)
    public void whenEmptyStackIsPopped_StackUnderflows() throws Exception {
        stack.pop();
    }

    @Test
    public void whenOneIsPushed_OneIsPopped() throws Exception {
        stack.push(1);
        assertEquals(1,stack.pop());
    }

    @Test
    public void whenOneAndTwoArePushed_TwoAndOneArePopped() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2,stack.pop());
        assertEquals(1,stack.pop());
    }

    @Test(expected = Stack.IllegalCapacity.class)
    public void whenCreatingStackWithNegativeCapacity_ShouldThrowIllegalCapacity() throws Exception {
        stack = Stack.Make(-1);
    }

    @Test(expected = Stack.Overflow.class)
    public void whenCreatingStackWithZeroCapacity_AnyPushShouldThrowOverflow() throws Exception {
        stack = Stack.Make(0);
        stack.push(1);
    }

    @Test(expected = Stack.Underflow.class)
    public void whenCreatingStackWithZeroCapacity_AnyPopShouldThrowUnderflow() throws Exception {
        stack = Stack.Make(0);
        stack.pop();
    }

    @Test
    public void whenOneIsPushed_OneIsOnTop() throws Exception {
        stack.push(1);
        assertEquals(1,stack.top());
    }

    @Test(expected = Stack.Empty.class)
    public void whenStackIsEmpty_TopThrowsEmpty() throws Exception {
        stack.top();
    }

    @Test(expected = Stack.Empty.class)
    public void withZeroCapacityStack_TopThrowsEmpty() throws Exception {
        stack = Stack.Make(0);
        stack.top();
    }

    @Test
    public void givenStackPushedWithThreeFour_FindOfThreeAndFourShouldReturnIndexFromTop() throws Exception {
        stack.push(3);
        stack.push(4);
        int indexOfThree = stack.find(3);
        assertEquals(1,indexOfThree);
        int indexOfFour = stack.find(4);
        assertEquals(0,indexOfFour);
    }

    @Test
    public void givenStackPushedWithThreeFour_FindOfFiveShoudReturnNull() throws Exception {
        stack.push(3);
        stack.push(4);
        assertNull(stack.find(5));
    }
}
