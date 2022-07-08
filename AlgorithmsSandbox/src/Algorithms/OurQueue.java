package Algorithms;

public interface OurQueue {
    void add(int value);
    int remove() throws QueueIsEmptyException;
    int peek() throws QueueIsEmptyException;
    boolean isEmpty();
}
