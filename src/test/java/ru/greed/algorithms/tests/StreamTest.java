package ru.greed.algorithms.tests;

import org.junit.jupiter.api.Test;
import ru.greed.algorithms.lesson.tenth.TenthLessonService;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamTest {

    private final TenthLessonService service = new TenthLessonService();

    @Test
    void shouldProcessCorrectData() {
        Stream<String> input = Stream.of(
                "вася 5",
                "Петя 3",
                "АНЯ 5",
                "Тото"
        );

        Map<Integer, List<String>> result = service.processStream(input);

        assertEquals(2, result.size(), "Должно быть 2 группы (номера 3 и 5)");

        assertEquals(List.of("Вася", "Аня"), result.get(5));
        assertEquals(List.of("Петя"), result.get(3));
    }

    @Test
    void shouldHandleDifferentRegistersAndDuplicates() {
        Stream<String> input = Stream.of(
                "иван 10",
                "ИВАН 10",
                "иВан 10"
        );

        Map<Integer, List<String>> result = service.processStream(input);

        assertEquals(1, result.size());
        assertEquals(List.of("Иван", "Иван", "Иван"), result.get(10));
    }

    @Test
    void shouldReturnEmptyMapForInvalidData() {
        Stream<String> input = Stream.of(
                "ЧеловекБезНомера",
                "   ",
                ""
        );

        Map<Integer, List<String>> result = service.processStream(input);

        assertTrue(result.isEmpty(), "Карта должна быть пустой, если нет валидных данных с номерами");
    }

    @Test
    void shouldHandleTwoNamesForOneNumber() {
        Stream<String> input = Stream.of(
                "Алексей 77",
                "Дмитрий 77"
        );

        Map<Integer, List<String>> result = service.processStream(input);

        assertEquals(2, result.get(77).size());
        assertTrue(result.get(77).contains("Алексей"));
        assertTrue(result.get(77).contains("Дмитрий"));
    }
}
