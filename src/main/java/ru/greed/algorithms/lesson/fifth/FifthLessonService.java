package ru.greed.algorithms.lesson.fifth;

import ru.greed.algorithms.utils.LogUtils;

public class FifthLessonService {

    private final GraphConverter converter = new GraphConverter();
    private final TopologicalSorter sorter = new TopologicalSorter();

    public void printLesson() {

        //Задание 1
        int[][] matrix1 = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };

        LogUtils.printMatrix(matrix1, converter.convertMatrix(matrix1));

        //Задание 2
        int[][] matrix2 = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };

        LogUtils.logTopologicalSort(matrix2, sorter.sort(matrix2));
    }
}
