package stack;

public class Stack {
    private int size;
    private int capacity;
    
    public static Stack Make(int capacity) {
        return new Stack(capacity);
    }
    private Stack(int capacity) {
        this.capacity = capacity;
    }
    
    public boolean isEmpty() {
        return (size==0);
    }
    
    public int getSize() {
        return size;
    }
    
    public void push(int element) {
        if (size == capacity)
            throw new Overflow();
        size++;
    }
    
    public void pop() {
        if (isEmpty())
            throw new Underflow();
        size--;
    }

    public class Overflow extends RuntimeException{
    }

    public class Underflow extends RuntimeException{
    }
    
}
