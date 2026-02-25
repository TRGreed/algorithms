package ru.greed.algorithms.utils;

import ru.greed.algorithms.model.Edge;
import ru.greed.algorithms.model.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LogUtils {

    public static void printNodeList(Map<String, Node> nodes) {
        System.out.println();
        System.out.println("===== УЗЛОВОЕ ПРЕДСТАВЛЕНИЕ =====");

        List<String> sortedKeys = new ArrayList<>(nodes.keySet());
        Collections.sort(sortedKeys);

        for (String key : sortedKeys) {
            Node node = nodes.get(key);
            System.out.println(node.getName());

            List<Edge> relations = node.getRelatedEdges();
            for (Edge relation : relations) {
                String prefix = "   --> ";

                System.out.printf("%s %s [%d(%d%%)]%n",
                        prefix, relation.getTargetNode().getName(), relation.getCapacity(), relation.getLose());
            }
        }
    }

    public static void printMatrix(Edge[][] matrix, String[] labels) {
        System.out.println();
        System.out.println("===== МАТРИЧНОЕ ПРЕДСТАВЛЕНИЕ =====");

        System.out.print("      ");
        for (String label : labels) System.out.printf("%-12s", label);
        System.out.println("\n" + "-".repeat(labels.length * 12 + 6));

        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%-5s| ", labels[i]);
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null) {
                    System.out.printf("%-12s", "---");
                } else {
                    String info = String.format("%d(%d%%)", matrix[i][j].getCapacity(), matrix[i][j].getLose());
                    System.out.printf("%-12s", info);
                }
            }
            System.out.println();
        }
    }
}
