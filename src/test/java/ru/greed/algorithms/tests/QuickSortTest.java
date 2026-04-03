package ru.greed.algorithms.tests;

import org.junit.jupiter.api.Test;
import ru.greed.algorithms.lesson.fourth.QuickSort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

public class QuickSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {3, 1, 2, 3, 3, 0, 2};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{0, 1, 2, 2, 3, 3, 3}, arr);
    }

    @Test
    void testNegativeNumbers() {
        int[] arr = {-5, -1, -3, 0, 2};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{-5, -3, -1, 0, 2}, arr);
    }

    @Test
    void testMixedNumbers() {
        int[] arr = {10, -1, 0, 5, 3, -10};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{-10, -1, 0, 3, 5, 10}, arr);
    }

    @Test
    void testAllEqual() {
        int[] arr = {7, 7, 7, 7, 7};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{7, 7, 7, 7, 7}, arr);
    }

    @Test
    void testLargeRandomArray() {
        Random random = new Random(42);
        int[] arr = new int[1000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000) - 5000;
        }

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        QuickSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testNullArray() {
        assertDoesNotThrow(() -> QuickSort.sort(null));
    }
}