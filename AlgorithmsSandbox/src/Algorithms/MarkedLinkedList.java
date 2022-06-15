package Algorithms;

public class MarkedLinkedList {
    MarkedNode head;

    MarkedLinkedList(int value) {
        this.head = new MarkedNode(value, null);
    }


    public MarkedNode getTail() {
        MarkedNode node = head;
        while (node != null) {
            if (node.next == null) {
                return node;
            }

            node = (MarkedNode) node.next;
        }

        return null;
    }

    public void addToTail(MarkedNode node) {
        MarkedNode lastNode = getTail();
        lastNode.next = node;
    }

    public MarkedNode findLoop() {
        MarkedNode res=head;

        while(res != null && !res.marker) {
            res.marker = true;
            res = (MarkedNode) res.next;
        }

        return res;
    }

    private void resetMarkers() {
        MarkedNode res=head;

        while(res != null && res.marker) {
            res.marker = false;
            res = (MarkedNode) res.next;
        }
    }


    @Override
    public String toString() {
        resetMarkers();

        MarkedNode node = head;
        StringBuilder res = new StringBuilder();
        while (node != null && !node.marker) {
            res.append(node);
            res.append(" -> ");

            node.marker = true;
            node = (MarkedNode) node.next;
        }

        return res.toString();
    }
}
