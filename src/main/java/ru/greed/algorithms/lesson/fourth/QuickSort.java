package ru.greed.algorithms.lesson.fourth;

import java.util.ArrayDeque;
import java.util.Deque;

public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // Стек для хранения границ подмассивов (left, right)
        Deque<int[]> stack = new ArrayDeque<>();

        // Начинаем с полного массива
        stack.push(new int[]{0, arr.length - 1});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int left = range[0];
            int right = range[1];

            if (left >= right) {
                continue;
            }

            // Разбиение массива
            int pivotIndex = partition(arr, left, right);

            // Добавляем подмассивы в стек
            if (pivotIndex - left > right - pivotIndex) {
                stack.push(new int[]{left, pivotIndex - 1});
                stack.push(new int[]{pivotIndex + 1, right});
            } else {
                stack.push(new int[]{pivotIndex + 1, right});
                stack.push(new int[]{left, pivotIndex - 1});
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {
        // Берём последний элемент как опорный
        int pivot = arr[right];

        // Индекс меньшего элемента
        int i = left - 1;

        for (int j = left; j < right; j++) {
            // Если текущий элемент меньше или равен pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Ставим pivot на правильное место
        swap(arr, i + 1, right);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
