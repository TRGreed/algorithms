package ru.greed.algorithms.lesson.first;

import ru.greed.algorithms.model.Edge;
import ru.greed.algorithms.model.Node;
import ru.greed.algorithms.utils.LogUtils;

import java.util.HashMap;
import java.util.Map;

public class FirstLessonService {

    public void start() {
        startNodeMethod();
        System.out.println();
        startMatrixMethod();
    }

    private void startMatrixMethod() {
        // Шпаргалка: A=0, B=1, C=2, D=3, E=4, F=5
        String[] labels = {"A", "B", "C", "D", "E", "F"};
        Edge[][] matrix = new Edge[6][6];

        addEdge(matrix, 0, 1, 1500, 90);
        addEdge(matrix, 0, 2, 2000, 10);
        addEdge(matrix, 0, 3, 1000, 50);
        addEdge(matrix, 1, 5, 1500, 60);
        addEdge(matrix, 2, 5, 500, 20);
        addEdge(matrix, 2, 4, 900, 5);
        addEdge(matrix, 3, 4, 2500, 1);
        addEdge(matrix, 4, 5, 300, 85);

        LogUtils.printMatrix(matrix, labels);
    }

    private void startNodeMethod() {
        Map<String, Node> nodes = new HashMap<>();
        for (String name : new String[]{"A", "B", "C", "D", "E", "F"}) {
            nodes.put(name, new Node(name));
        }

        linkNodes(1500, 90, nodes.get("A"), nodes.get("B"));
        linkNodes(2000, 10, nodes.get("A"), nodes.get("C"));
        linkNodes(1000, 50, nodes.get("A"), nodes.get("D"));
        linkNodes(1500, 60, nodes.get("B"), nodes.get("F"));
        linkNodes(500, 20, nodes.get("C"), nodes.get("F"));
        linkNodes(900, 5, nodes.get("C"), nodes.get("E"));
        linkNodes(2500, 1, nodes.get("D"), nodes.get("E"));
        linkNodes(300, 85, nodes.get("E"), nodes.get("F"));

        LogUtils.printNodeList(nodes);
    }

    private void addEdge(Edge[][] matrix, int u, int v, int cap, int loss) {
        matrix[u][v] = matrix[v][u] = new Edge(cap, loss);
    }

    private void linkNodes(int capacity, int lost, Node firstNode, Node secondNode) {
        firstNode.addRelation(capacity, lost, secondNode);
        secondNode.addRelation(capacity, lost, firstNode);
    }
}
