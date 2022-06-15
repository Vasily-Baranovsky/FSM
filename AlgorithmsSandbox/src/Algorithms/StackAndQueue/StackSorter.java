package Algorithms.StackAndQueue;

public class StackSorter {
    static public void sortStack(ArrayStack inStack) throws StackIsEmptyException, StackOverflowException {
        ArrayStack auxiliaryStack = new ArrayStack(inStack.getMaxLength());

        while (!inStack.isEmpty()) {
            int value = inStack.pop();

            while (!auxiliaryStack.isEmpty() && auxiliaryStack.peek() < value) {
                inStack.push(auxiliaryStack.pop());
            }

            auxiliaryStack.push(value);
        }

        while (!auxiliaryStack.isEmpty()) {
            inStack.push(auxiliaryStack.pop());
        }
    }
}
