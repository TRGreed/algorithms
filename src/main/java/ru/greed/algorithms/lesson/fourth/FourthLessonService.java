package ru.greed.algorithms.lesson.fourth;

import ru.greed.algorithms.utils.LogUtils;

import java.util.Arrays;
import java.util.Random;

public class FourthLessonService {

    public void printTestSort() {

        Random random = new Random(42);
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000) - 5000;
        }

        int[] copyArr = Arrays.copyOf(arr, arr.length);

        QuickSort.sort(arr);

        LogUtils.printQuickSort(copyArr, arr);
    }
}
