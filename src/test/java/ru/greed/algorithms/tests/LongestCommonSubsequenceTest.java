package ru.greed.algorithms.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.greed.algorithms.lesson.seventh.LongestCommonSubsequence;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LongestCommonSubsequenceTest {

    @Test
    @DisplayName("Проверка примера из задания")
    void testExampleFromLesson() {
        String s1 = "ABDEFADRFG";
        String s2 = "DAFERG";

        List<String> expected = List.of("DAFG", "AFRG", "AERG", "DFRG", "DERG", "DARG");
        List<String> actual = LongestCommonSubsequence.find(s1, s2);

        assertEquals(expected.size(), actual.size(), "Количество найденных LCS не совпадает");
        assertTrue(actual.containsAll(expected), "Результат не содержит все ожидаемые подпоследовательности");
    }

    @Test
    @DisplayName("Проверка другого примера 1")
    void testExample1() {
        String s1 = "XMJYAUZ";
        String s2 = "MZJAWXU";

        List<String> expected = List.of("MJAU");
        List<String> actual = LongestCommonSubsequence.find(s1, s2);

        assertEquals(expected.size(), actual.size(), "Количество найденных LCS не совпадает");
        assertTrue(actual.containsAll(expected), "Результат не содержит все ожидаемые подпоследовательности");
    }

    @Test
    @DisplayName("Проверка другого примера 2")
    void testExample2() {
        String s1 = "ACCGGTC";
        String s2 = "GTCGTTC";

        List<String> expected = List.of("CGTC", "GGTC");
        List<String> actual = LongestCommonSubsequence.find(s1, s2);

        assertEquals(expected.size(), actual.size(), "Количество найденных LCS не совпадает");
        assertTrue(actual.containsAll(expected), "Результат не содержит все ожидаемые подпоследовательности");
    }

    @Test
    @DisplayName("Проверка другого примера 3")
    void testExample3() {
        String s1 = "ABBA";
        String s2 = "BAAB";

        List<String> expected = List.of("AA", "BB", "AB", "BA");
        List<String> actual = LongestCommonSubsequence.find(s1, s2);

        assertEquals(expected.size(), actual.size(), "Количество найденных LCS не совпадает");
        assertTrue(actual.containsAll(expected), "Результат не содержит все ожидаемые подпоследовательности");
    }

    @Test
    @DisplayName("Проверка другого примера 4")
    void testExample4() {
        String s1 = "STREAMS";
        String s2 = "REAMS";

        List<String> expected = List.of("REAMS");
        List<String> actual = LongestCommonSubsequence.find(s1, s2);

        assertEquals(expected.size(), actual.size(), "Количество найденных LCS не совпадает");
        assertTrue(actual.containsAll(expected), "Результат не содержит все ожидаемые подпоследовательности");
    }

    @Test
    @DisplayName("Строки без общих символов")
    void testNoCommonSubsequence() {
        List<String> result = LongestCommonSubsequence.find("ABC", "XYZ");
        assertTrue(result.contains(""), "Должна вернуться пустая строка");
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Идентичные строки")
    void testIdenticalStrings() {
        String s = "HELLO";
        List<String> result = LongestCommonSubsequence.find(s, s);
        assertEquals(List.of("HELLO"), result);
    }

    @Test
    @DisplayName("Пустые строки")
    void testEmptyStrings() {
        List<String> result = LongestCommonSubsequence.find("", "ABC");
        assertTrue(result.contains(""));
    }
}
