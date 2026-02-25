package ru.greed.algorithms;

import ru.greed.algorithms.lesson.first.FirstLessonService;

public class AlgorithmsApplication {

    public static void main(String[] args) {
        String lesson = args[0];

        switch (Integer.parseInt(lesson)) {
            case 1 -> new FirstLessonService().start();
            default -> System.out.println("Некорректный номер занятия");
        }
    }

}
