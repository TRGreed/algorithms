package ru.greed.algorithms.tests;

import org.junit.jupiter.api.Test;
import ru.greed.algorithms.lesson.fifth.GraphConverter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphConverterTest {

    private final GraphConverter converter = new GraphConverter();

    @Test
    void shouldExtractEdgesFromProvidedExample() {
        int[][] inputMatrix = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] expectedOutput = {
                {0, 1},
                {0, 2},
                {1, 0},
                {1, 2},
                {1, 3},
                {2, 0},
                {2, 1}
        };

        assertArrayEquals(expectedOutput, converter.convertMatrix(inputMatrix));
    }

    @Test
    void shouldReturnEmptyArrayForEmptyGraph() {
        int[][] emptyMatrix = {{0, 0}, {0, 0}};
        assertEquals(0, converter.convertMatrix(emptyMatrix).length);
    }
}
