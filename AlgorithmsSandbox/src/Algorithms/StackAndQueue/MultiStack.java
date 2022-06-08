package Algorithms.StackAndQueue;

import java.util.ArrayList;

public class MultiStack {
    ArrayList<ArrayStack> multiStack; // здесь полки!
    int multiStackLength; // здесь тарелки!
    int singleStackLength; //это константа!!!!!!!!!!!!!!!!!!!111 - максимальный размер одного стека

    public MultiStack(int singleStackLength) {
        multiStack = new ArrayList<ArrayStack>();
        multiStackLength = 0;
        this.singleStackLength = singleStackLength;
    }

    public void push(int value) {
        multiStackLength++;
        int stackIndex = getStackIndex();//количество полок!
        if (multiStack.size() <= stackIndex) {
            multiStack.add(new ArrayStack(singleStackLength)); //use previously written stack
        }
        ArrayStack currentStack = multiStack.get(stackIndex);
        try {
            currentStack.push(value);
        } catch (StackOverflowException e) {
            throw new RuntimeException("Got stackOverflow during pushing");
        }
    }

    public boolean isEmpty() {
        return multiStackLength == 0;
    }

    public int pop() throws StackIsEmptyException {
        if (isEmpty()) {
            throw new StackIsEmptyException();
        }
        int stackIndex = getStackIndex();
        ArrayStack currentStack = multiStack.get(stackIndex);
        int value;
        try {
            value = currentStack.pop();
        } catch (StackIsEmptyException e) {
            throw new RuntimeException("Got stack is empty during popping");
        }
        multiStackLength--;
        return value;
    }

    public int peek() throws StackIsEmptyException {
        if (isEmpty()) {
            throw new StackIsEmptyException();
        }
        int stackIndex = getStackIndex();
        ArrayStack currentStack = multiStack.get(stackIndex);
        int value;
        try {
            value = currentStack.peek();
        } catch (StackIsEmptyException e) {
            throw new RuntimeException("Got stack is empty during peeking");
        }
        return value;
    }

    public int getStackIndex() {
        return (multiStackLength - 1) / singleStackLength;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MultiStack: ");
        stringBuilder.append("\n");
        for (int i = 0; i < multiStack.size(); i++) {
            stringBuilder.append(multiStack.get(i));
            if(i != multiStack.size() - 1) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("MultiStackLength: ").append(multiStackLength);
        stringBuilder.append("; ");
        return stringBuilder.toString();
    }
}
