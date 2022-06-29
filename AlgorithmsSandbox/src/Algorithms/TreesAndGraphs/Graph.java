package Algorithms.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private int lastIndex=0;
    final private ArrayList<GraphNode> allNodes = new ArrayList<>();

    public void addNode(GraphNode node) {
        node.id = lastIndex;
        allNodes.add(node);
        lastIndex++;
    }

    public GraphNode addNode(String value) {
        GraphNode node = new GraphNode(value, lastIndex);
        allNodes.add(node);
        lastIndex++;

        return node;
    }
    
    public Graph addConnection(String nodeBegin, String nodeEnd) {

        GraphNode tmpNodeBegin=null;
        GraphNode tmpNodeEnd=null;
        for (GraphNode node : allNodes) {
            if (nodeBegin.equalsIgnoreCase(node.value)) {
                tmpNodeBegin = node;
            }

            if (nodeEnd.equalsIgnoreCase(node.value)) {
                tmpNodeEnd = node;
            }

            if (tmpNodeBegin != null && tmpNodeEnd != null) {
                break;
            }
        }

        if (tmpNodeBegin != null && tmpNodeEnd != null) {
            tmpNodeBegin.addConnection(tmpNodeEnd);
        }

        return this;
    }

    public void addConnection(GraphNode nodeBegin, GraphNode nodeEnd) {
        nodeBegin.addConnection(nodeEnd);
    }


    public boolean isRouteExists(GraphNode nodeStart, GraphNode nodeFinish) {

        boolean[] visitedNodes = new boolean[allNodes.size()];


        Queue<GraphNode> queueOfNodes = new LinkedList<>();
        queueOfNodes.add(nodeStart);

        GraphNode currentNode;
        while (!queueOfNodes.isEmpty()) {
            currentNode = queueOfNodes.poll();

            // с помощью правой части условия исключаем рефлексию (т.е. существования связи из себя в себя, даже если это явно не указано в списке коннекшнов)
            if (currentNode == nodeFinish && visitedNodes[currentNode.id]) {
                return true;
            }
            else {
                for (GraphNode node: currentNode.nodes) {
                    if (!visitedNodes[node.id]) {
                        queueOfNodes.add(node);
                        visitedNodes[node.id] = true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {

        String res = "Graph{" +
                allNodes +
                "\r\n}";

        return res.replace(",","");
    }

    class GraphNode {
        protected Integer id=null;
        String value;
        protected ArrayList<GraphNode> nodes = new ArrayList<>();


        protected GraphNode(GraphNode node, Integer id) {
            this.value = node.value;
            this.nodes = node.nodes;

            this.id = id;
        }

        protected GraphNode(String value, Integer id) {
            this.value = value;
            this.id = id;
        }

        public GraphNode(String value, ArrayList<GraphNode> nodes) {
            this.value = value;
            this.nodes = nodes;
        }

        public void addConnection(GraphNode node) {
            nodes.add(node);
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder("\r\nGraphNode{ value='");
            sb.append(value).append("'; ");
            sb.append("connected nodes: {");
            for (GraphNode node: nodes) {
                sb.append(node.value).append(" ");
            }
            sb.append("}}");

            return sb.toString();
        }
    }
}
