package Algorithms;

public interface Queue {
    public boolean add (int value);
    public int remove () throws QueueIsEmptyException;
    public int peek () throws QueueIsEmptyException;
    public boolean isEmpty ();
}
