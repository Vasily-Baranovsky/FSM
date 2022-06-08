package Algorithms.StackAndQueue;

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array: ");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if(i != array.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("; ");
        stringBuilder.append("stackLength: ").append(stackLength);
        stringBuilder.append("; ");
        return stringBuilder.toString();
    }
}

class StackIsEmptyException extends Exception {}

class StackOverflowException extends Exception {}
