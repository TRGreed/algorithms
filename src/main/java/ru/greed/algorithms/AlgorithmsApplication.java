package ru.greed.algorithms;

import ru.greed.algorithms.lesson.first.FirstLessonService;
import ru.greed.algorithms.utils.LogUtils;

public class AlgorithmsApplication {

    private static final FirstLessonService firstLessonService = new FirstLessonService();

    public static void main(String[] args) {
        String lesson = args[0];

        switch (Integer.parseInt(lesson)) {
            case 1 -> {
                LogUtils.printNodeList(firstLessonService.nodesNet());
                LogUtils.printMatrix(firstLessonService.matrixNet(), firstLessonService.getLabels());
            }
            default -> System.out.println("Некорректный номер занятия");
        }
    }

}
