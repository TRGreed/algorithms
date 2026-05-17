package ru.greed.algorithms.lesson.tenth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TenthLessonService {

    public Map<Integer, List<String>> processFile(String fileName) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IOException("Файл не найден: " + fileName);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return processStream(reader.lines());
        }
    }

    public Map<Integer, List<String>> processStream(Stream<String> lines) {
        return lines
                .parallel()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(line -> line.split("\\s+"))
                .filter(parts -> parts.length >= 2)
                .collect(Collectors.groupingBy(
                        parts -> Integer.parseInt(parts[1]),
                        Collectors.mapping(
                                parts -> formatName(parts[0]),
                                Collectors.toList()
                        )
                ));
    }

    private String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public void logResult(Map<Integer, List<String>> data) {
        if (data == null || data.isEmpty()) {
            System.out.println("Результат пуст.");
            return;
        }

        System.out.println("--- Результат обработки ---");
        data.forEach((number, names) -> {
            System.out.printf("Номер [%d]: %s%n", number, String.join(", ", names));
        });
        System.out.println("---------------------------");
    }
}

