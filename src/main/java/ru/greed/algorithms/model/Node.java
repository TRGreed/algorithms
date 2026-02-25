package ru.greed.algorithms.model;

import java.util.ArrayList;
import java.util.List;

public class Node {

    String name;
    List<Edge> relatedEdges = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public void addRelation(int capacity, int lose, Node targetNode) {
        relatedEdges.add(new Edge(capacity, lose, targetNode));
    }

    public String getName() {
        return name;
    }

    public List<Edge> getRelatedEdges() {
        return relatedEdges;
    }
}
