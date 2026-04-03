package ru.greed.algorithms.utils;

import ru.greed.algorithms.model.Edge;
import ru.greed.algorithms.model.MinMaxDto;
import ru.greed.algorithms.model.Node;

import java.util.*;
import java.util.stream.Collectors;

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

    public static void printMinMax(MinMaxDto dto) {
        System.out.printf("Минимальное значение массива: %d, Максимальное значение массива: %d.", dto.getMin(), dto.getMax());
    }

    public static void printQuickSort(int[] arr, int[] sortedArr) {
        System.out.println("===== Несортированный массив =====");
        System.out.println(Arrays.toString(arr));
        System.out.println("===== Отсортированный массив =====");
        System.out.println(Arrays.toString(sortedArr));
    }

    public static void printMatrix(int[][] startMatrix, int[][] convertedMatrix) {
        System.out.println();
        System.out.println("===== УРОК 5. Задание 1. Преобразование матрицы =====");

        System.out.println("\n Исходная матрица смежности:");
        if (startMatrix == null || startMatrix.length == 0) {
            System.out.println("(пустая матрица)");
        } else {
            for (int[] matrix : startMatrix) {
                System.out.println(Arrays.toString(matrix));
            }
        }

        System.out.println("\n Cписок рёбер:");
        if (convertedMatrix == null || convertedMatrix.length == 0) {
            System.out.println("Ребра отсутствуют.");
        } else {
            for (int[] matrix : convertedMatrix) {
                System.out.printf("%d ➔ %d%n",
                        matrix[0], matrix[1]);
            }
        }
    }

    public static void logTopologicalSort(int[][] startMatrix, List<Integer> sortedNodes) {
        System.out.println();
        System.out.println("===== УРОК 5. Задание 1. Топологическая сортировка. Алгоритм Тарьяна =====");

        System.out.println("\nИсходный граф:");
        for (int i = 0; i < startMatrix.length; i++) {
            String dependencies = "";
            for (int j = 0; j < startMatrix[i].length; j++) {
                if (startMatrix[i][j] == 1) {
                    dependencies += j + " ";
                }
            }
            System.out.println();
            System.out.printf("%d ➔ %s",
                    i, dependencies.isEmpty() ? "null" : dependencies);
        }

        System.out.println();
        System.out.println("\nРезультат сортировки:");
        if (sortedNodes == null || sortedNodes.isEmpty()) {
            System.out.println("    Список пуст.");
        } else {
            String path = sortedNodes.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ➔ "));
            System.out.println(path);
        }

        System.out.println("\n" + "=".repeat(50));
    }
}
