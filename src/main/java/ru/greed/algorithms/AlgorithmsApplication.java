package ru.greed.algorithms;

import ru.greed.algorithms.lesson.first.FirstLessonService;
import ru.greed.algorithms.lesson.second.SecondLessonService;
import ru.greed.algorithms.lesson.third.ThirdLessonService;
import ru.greed.algorithms.utils.LogUtils;

import java.util.List;

public class AlgorithmsApplication {

    private static final FirstLessonService firstLessonService = new FirstLessonService();
    private static final SecondLessonService secondLessonService = new SecondLessonService();
    private static final ThirdLessonService thirdLessonService = new ThirdLessonService();

    public static void main(String[] args) {
        String lesson = args[0];

        switch (Integer.parseInt(lesson)) {
            case 1 -> {
                LogUtils.printNodeList(firstLessonService.nodesNet());
                LogUtils.printMatrix(firstLessonService.matrixNet(), firstLessonService.getLabels());
            }
            case 2 -> LogUtils.printMinMax(secondLessonService.findMinMaxCompact(List.of(10, 2, 8, 4, 5, 20, -5, 21, 0, 1)));
            case 3 -> thirdLessonService.printTestList();
            default -> System.out.println("Некорректный номер занятия");
        }
    }

}
