package Algorithms;

public class MarkedNode extends Node {
    boolean marker = false;

    MarkedNode(int value, Node next) {
        super(value, next);

        marker = false;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Val=");
        res.append(value);
        res.append(";Marker=");
        res.append(marker);

        return res.toString();
    }
}