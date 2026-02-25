package ru.greed.algorithms.model;

public class Edge {

    int capacity;
    int lose;
    Node targetNode;

    public Edge(int capacity, int lose) {
        this.capacity = capacity;
        this.lose = lose;
    }

    public Edge(int capacity, int lose, Node targetNode) {
        this.capacity = capacity;
        this.lose = lose;
        this.targetNode = targetNode;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLose() {
        return lose;
    }

    public Node getTargetNode() {
        return targetNode;
    }
}
