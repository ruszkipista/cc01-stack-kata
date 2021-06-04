package stack;

public class Stack {
    private int size;
    private int capacity;
    private int elements[];
    
    public static Stack Make(int capacity) {
        if (capacity<0)
            throw new IllegalCapacity();
        return new Stack(capacity);
    }
    private Stack(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public int getSize() {
        return size;
    }
    
    public void push(int element) {
        if (size == capacity)
            throw new Overflow();
        this.elements[size++] = element;
    }
    
    public int pop() {
        if (isEmpty())
            throw new Underflow();
        return elements[--size];
    }

    public int top() {
        return elements[size-1];
    }

    public class Overflow extends RuntimeException{
    }

    public class Underflow extends RuntimeException{
    }

    public static class IllegalCapacity extends RuntimeException {
    }

}
