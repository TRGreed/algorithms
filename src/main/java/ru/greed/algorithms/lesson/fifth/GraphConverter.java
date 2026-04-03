package ru.greed.algorithms.lesson.fifth;

import java.util.ArrayList;
import java.util.List;

public class GraphConverter {

    public int[][] convertMatrix(int[][] startMatrix) {
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < startMatrix.length; i++) {
            for (int j = 0; j < startMatrix[i].length; j++) {
                if (startMatrix[i][j] == 1) {
                    edges.add(new int[]{i, j});
                }
            }
        }

        return edges.toArray(new int[0][]);
    }
}

