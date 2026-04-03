package ru.greed.algorithms.tests;

import org.junit.jupiter.api.Test;
import ru.greed.algorithms.lesson.fifth.TopologicalSorter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TopologicalSorterTest {

    private final TopologicalSorter sorter = new TopologicalSorter();

    @Test
    void shouldSortLinearGraph() {
        int[][] matrix = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };

        List<Integer> result = sorter.sort(matrix);
        assertEquals(List.of(0, 1, 2, 3), result);
    }

    @Test
    void shouldThrowExceptionOnCycle() {
        int[][] cyclicMatrix = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> sorter.sort(cyclicMatrix));
    }

    @Test
    void shouldHandleSingleNode() {
        int[][] singleNodeMatrix = {{0}};
        assertEquals(List.of(0), sorter.sort(singleNodeMatrix));
    }
}
