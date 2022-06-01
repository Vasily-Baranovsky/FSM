package Algorithms.StackAndQueue;

import Algorithms.OurListStack;
import Algorithms.OurStack;
import Algorithms.StackIsEmptyException;

public class StackWithMin implements OurStack {
    private static class ValueAndMinContainer {
        int value;
        int currentMin;

        ValueAndMinContainer(int value, int currentMin) {
            this.value = value;
            this.currentMin = currentMin;
        }
    }
    GenericListStack<ValueAndMinContainer> stack = new GenericListStack<ValueAndMinContainer>();

    @Override
    public boolean push(int value) {
        int currentMin;
        try {
            currentMin = Math.min(value, getMin());
        } catch (StackIsEmptyException e) {
            currentMin = value;
        }

        return stack.push(new ValueAndMinContainer(value, currentMin));
    }

    public int getMin() throws StackIsEmptyException {
        return stack.peek().currentMin;
    }

    @Override
    public int pop() throws StackIsEmptyException {
        return stack.pop().value;
    }

    @Override
    public int peek() throws StackIsEmptyException {
        return stack.peek().value;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
