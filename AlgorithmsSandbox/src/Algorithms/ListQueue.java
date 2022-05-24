package Algorithms;

public class ListQueue implements Queue {
    Node head=null;
    Node tail=null;

    @Override
    public boolean add (int value) {
        Node newNode = new Node(value);
        if (tail==null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        return true;
    }

    @Override
    public int remove() throws QueueIsEmptyException {
        if (head==null) {
            throw new QueueIsEmptyException();
        }

        int result = head.value;
        head = head.next;
        if (head==null) {
            tail = null;
        }

        return result;
    }

    @Override
    public int peek() throws QueueIsEmptyException {
        if (head==null) {
            throw new QueueIsEmptyException();
        }

        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }


    @Override
    public String toString() {
        StringBuilder resultBuilder = new StringBuilder();
        Node cursor = head;
        while (cursor != null) {
            resultBuilder.append("<-" + cursor.value);
            cursor = cursor.next;
        }
        return resultBuilder.toString();
    }
}