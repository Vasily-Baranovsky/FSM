package Algorithms;

public class OurListStack implements OurStack {
    Node top;

    @Override
    public boolean push(int value){
        top = new Node (value, top);
        return true;
    }

    @Override
    public int pop() throws StackIsEmptyException {
        if (top == null) {
            throw new StackIsEmptyException();
        }

        int value = top.value;
        top = top.next;
        return value;
    }

    @Override
    public int peek() throws StackIsEmptyException {
        if (top == null) {
            throw new StackIsEmptyException();
        }
        return top.value;
    }

    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node currentPointer = top;

        while (currentPointer!=null) {
            builder.append(currentPointer.value);
            builder.append("; ");
            currentPointer = currentPointer.next;
        }

        return builder.toString();
    }
}
