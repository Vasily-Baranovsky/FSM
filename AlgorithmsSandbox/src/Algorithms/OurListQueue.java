package Algorithms;

public class OurListQueue implements OurQueue {
    Node top;
    Node bottom;

    @Override
    public void add(int value) {
        Node tmp = new Node(value, null);
        if (bottom != null) {
            bottom.next = tmp;
        }

        bottom = tmp;

        if (top == null) {
            top = bottom;
        }
    }

    @Override
    public int remove() throws QueueIsEmptyException {
        if (top == null) {
            throw new QueueIsEmptyException();
        }

        int res = top.value;
        top = top.next;
        if (top == null) {
            bottom = null;
        }

        return res;
    }

    @Override
    public int peek() throws QueueIsEmptyException {
        if (top == null) {
            throw new QueueIsEmptyException();
        }

        return top.value;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
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
