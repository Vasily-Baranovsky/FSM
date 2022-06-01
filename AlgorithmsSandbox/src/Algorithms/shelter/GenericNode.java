package Algorithms.shelter;

public class GenericNode<T> {
    public GenericNode<T> next;
    public T value;

    public GenericNode(T value, GenericNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public GenericNode(T value) {
        this (value, null);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
