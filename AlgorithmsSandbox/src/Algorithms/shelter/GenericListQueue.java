package Algorithms.shelter;

import Algorithms.QueueIsEmptyException;

public class GenericListQueue<T> {
    GenericNode<T> head=null;
    GenericNode<T> tail=null;


    public boolean add (T value) {
        GenericNode<T> newGenericNode = new GenericNode<T>(value);
        if (tail==null) {
            head = newGenericNode;
            tail = newGenericNode;
        } else {
            tail.next = newGenericNode;
            tail = newGenericNode;
        }
        return true;
    }


    public T remove() throws QueueIsEmptyException {
        if (head==null) {
            throw new QueueIsEmptyException();
        }

        T result = head.value;
        head = head.next;
        if (head==null) {
            tail = null;
        }

        return result;
    }


    public T peek() throws QueueIsEmptyException {
        if (head==null) {
            throw new QueueIsEmptyException();
        }

        return head.value;
    }


    public boolean isEmpty() {
        return head == null;
    }


    @Override
    public String toString() {
        StringBuilder resultBuilder = new StringBuilder();
        GenericNode<T> cursor = head;
        while (cursor != null) {
            resultBuilder.append("<-" + cursor.value);
            cursor = cursor.next;
        }
        return resultBuilder.toString();
    }
}
