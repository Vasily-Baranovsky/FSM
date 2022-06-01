package Algorithms.StackAndQueue;

import java.lang.reflect.Array;

public class ArrayStack {

    int[] array;
    int stackLength = 0;

    public ArrayStack(int maxLength) {
        array = new int[maxLength];
    }

    public void push(int value) throws StackOverflowException {
        if (stackLength == array.length) {
            throw new StackOverflowException();
        }
        array[stackLength++] = value;
    }

    public int pop () throws StackIsEmptyException {
        if (stackLength == 0) {
            throw new StackIsEmptyException();
        }
        int value = array[stackLength-1];
        stackLength--;
        return value;
    }

    public boolean isEmpty() {
        return stackLength == 0;
    }

    public int peek() throws StackIsEmptyException {
        if (isEmpty()) {
            throw new StackIsEmptyException();
        }
        return array[stackLength-1];
    }
}

class StackIsEmptyException extends Exception {}

class StackOverflowException extends Exception {}


