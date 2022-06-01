package Algorithms.StackAndQueue;

import Algorithms.Node;
import Algorithms.StackIsEmptyException;
import Algorithms.shelter.GenericNode;

public class GenericListStack <T> {
    GenericNode<T> top;

    public boolean push(T value){
        top = new GenericNode<T> (value, top);
        return true;
    }

    public T pop() throws Algorithms.StackIsEmptyException {
        if (top == null) {
            throw new Algorithms.StackIsEmptyException();
        }

        T value = top.value;
        top = top.next;
        return value;
    }

    public T peek() throws Algorithms.StackIsEmptyException {
        if (top == null) {
            throw new StackIsEmptyException();
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top==null;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        GenericNode<T> currentPointer = top;

        while (currentPointer!=null) {
            builder.append(currentPointer.value);
            builder.append("; ");
            currentPointer = currentPointer.next;
        }

        return builder.toString();
    }
}
