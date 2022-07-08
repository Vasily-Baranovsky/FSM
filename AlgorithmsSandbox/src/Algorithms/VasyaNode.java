package Algorithms;

public class VasyaNode {
    VasyaNode next;
    int value;

    VasyaNode(int value, VasyaNode next) {
        this.next = next;
        this.value = value;
    }

    VasyaNode(int value) {
        this(value, null);
    }

    @Override
    public String toString() {
        return "VasyaNode{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }
}
