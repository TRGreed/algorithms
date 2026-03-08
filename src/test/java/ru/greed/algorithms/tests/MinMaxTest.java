package ru.greed.algorithms.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.greed.algorithms.lesson.second.SecondLessonService;
import ru.greed.algorithms.model.MinMaxDto;

import java.util.List;

public class MinMaxTest {

    private static final SecondLessonService secondLessonService = new SecondLessonService();

    @Test
    public void mainTest() {
        List<Integer> list1 = List.of(3, 5, 1, 2, 4, 11, 0, -3, 7, 4, 15);
        MinMaxDto result1 = secondLessonService.findMinMaxCompact(list1);
        Assertions.assertEquals(-3, result1.getMin());
        Assertions.assertEquals(15, result1.getMax());

        List<Integer> list2 = List.of(10, 2, 8, 4, 5, 20, -5, 21, 0, 1);
        MinMaxDto result2 = secondLessonService.findMinMaxCompact(list2);
        Assertions.assertEquals(-5, result2.getMin());
        Assertions.assertEquals(21, result2.getMax());

        List<Integer> list3 = List.of(62);
        MinMaxDto result3 = secondLessonService.findMinMaxCompact(list3);
        Assertions.assertEquals(62, result3.getMin());
        Assertions.assertEquals(62, result3.getMax());
    }
}
