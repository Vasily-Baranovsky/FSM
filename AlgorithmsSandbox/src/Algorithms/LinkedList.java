package Algorithms;

public class LinkedList {
    Node head;

    LinkedList(int firstValue) {
        head = new Node (firstValue);
    }

    public Node addToTail (Node node) {
        if (head == null) {
            head = node;
        }

        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = node;
        return node;
    }

    public Node addToTail (int value) {
        return addToTail(new Node (value));
    }

    public Node getKthFromTail (int k) {
        Node scout = head;
        Node main = head;

        for (int i=0; i<k; i++) {
            if (scout == null) {
                return null;
            } else {
                scout = scout.next;
            }
        }

        while (scout != null) {
            scout = scout.next;
            main = main.next;
        }
        return main;
    }

    public void partition (int value) {
        Node leftPartition = null;
        Node leftPartitionTail = null;
        Node rightPartition = null;
        Node currentNode = head;

        while (currentNode!=null) {
            Node nextNode = currentNode.next;
            if (currentNode.value < value) {
                currentNode.next = leftPartition;
                leftPartition = currentNode;
                if (leftPartitionTail==null) {
                    leftPartitionTail = leftPartition;
                }
            } else {
                currentNode.next = rightPartition;
                rightPartition = currentNode;
            }
            currentNode = nextNode;
        }
        if (leftPartition != null) {
            head = leftPartition;
            leftPartitionTail.next = rightPartition;
        } else {
            head = rightPartition;
        }
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        Node currentNode = head;

        while (currentNode != null) {
            buffer.append(currentNode.value);
            buffer.append(", ");
            currentNode = currentNode.next;
        }
        return buffer.toString();
    }
}