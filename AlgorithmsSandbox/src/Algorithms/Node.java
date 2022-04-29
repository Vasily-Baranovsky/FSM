package Algorithms;

import java.io.Serializable;

public class Node {
    Node next;
    int value;

    Node (int value, Node next) {
        this.value = value;
        this.next = next;
    }

    Node (int value) {
        this (value, null);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
