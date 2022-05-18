package Algorithms;

public interface OurStack {

    public boolean push(int value);

    public int pop() throws StackIsEmptyException;

    public int peek() throws StackIsEmptyException;

    public boolean isEmpty();
}
