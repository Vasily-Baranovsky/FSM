package Algorithms.TreesAndGraphs;

import org.junit.jupiter.api.Test;

class GraphTest {

    @Test
    public void testGraphRoute() {
        Graph graph = new Graph();
        Graph.GraphNode nodeA = graph.addNode("a");
        Graph.GraphNode nodeB = graph.addNode("b");
        Graph.GraphNode nodeC = graph.addNode("c");
        Graph.GraphNode nodeD = graph.addNode("d");
        Graph.GraphNode nodeE = graph.addNode("e");

        graph.addConnection(nodeA, nodeA);
        graph.addConnection(nodeA, nodeE);
        graph.addConnection(nodeA, nodeC);
        graph.addConnection(nodeB, nodeA);
        graph.addConnection(nodeC, nodeA);
        graph.addConnection(nodeC, nodeB);
        graph.addConnection(nodeC, nodeE);
        graph.addConnection(nodeD, nodeB);


        System.out.println(graph);


        System.out.println("a-b: "+ graph.isRouteExists(nodeA, nodeB));
        System.out.println("a-d: "+ graph.isRouteExists(nodeA, nodeD));
        System.out.println("d-b: "+ graph.isRouteExists(nodeD, nodeB));
        System.out.println("b-d: "+ graph.isRouteExists(nodeB, nodeD));
        System.out.println("a-a: "+ graph.isRouteExists(nodeA, nodeA));
        System.out.println("b-b: "+ graph.isRouteExists(nodeB, nodeB));
        System.out.println("b-c: "+ graph.isRouteExists(nodeB, nodeC));
        System.out.println("c-b: "+ graph.isRouteExists(nodeC, nodeB));
        System.out.println("e-e: "+ graph.isRouteExists(nodeE, nodeE));
    }

}