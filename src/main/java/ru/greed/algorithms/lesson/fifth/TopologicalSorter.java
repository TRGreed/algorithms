package ru.greed.algorithms.lesson.fifth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TopologicalSorter {

    private enum NodeStatus {
        UNVISITED,
        VISITING,
        VISITED
    }

    public List<Integer> sort(int[][] startMatrix) {
        int nodeCount = startMatrix.length;
        NodeStatus[] statuses = new NodeStatus[nodeCount];
        Arrays.fill(statuses, NodeStatus.UNVISITED);

        List<Integer> result = new ArrayList<>();

        for (int currentNode = 0; currentNode < nodeCount; currentNode++) {
            if (statuses[currentNode] == NodeStatus.UNVISITED) {
                depthFirstSearch(currentNode, startMatrix, statuses, result);
            }
        }

        Collections.reverse(result);
        return result;
    }

    private void depthFirstSearch(int node, int[][] matrix, NodeStatus[] statuses, List<Integer> result) {
        statuses[node] = NodeStatus.VISITING;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[node][i] == 1) {
                if (statuses[i] == NodeStatus.VISITING) {
                    throw new IllegalStateException("Обнаружен цикл. Граф не является ациклическим.");
                }
                if (statuses[i] == NodeStatus.UNVISITED) {
                    depthFirstSearch(i, matrix, statuses, result);
                }
            }
        }

        statuses[node] = NodeStatus.VISITED;
        result.add(node);
    }
}
