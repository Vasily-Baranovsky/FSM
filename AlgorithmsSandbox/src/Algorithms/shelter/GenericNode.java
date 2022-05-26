package Algorithms.shelter;

public class GenericNode<T> {
    GenericNode<T> next;
    T value;

    GenericNode(T value, GenericNode<T> next) {
        this.value = value;
        this.next = next;
    }

    GenericNode(T value) {
        this (value, null);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
