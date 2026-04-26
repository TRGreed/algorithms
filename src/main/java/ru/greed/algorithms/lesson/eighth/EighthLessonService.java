package ru.greed.algorithms.lesson.eighth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class EighthLessonService {

    private final MaskingParser parser = new MaskingParser();

    /**
     * Читает файл из папки resources, маскирует данные и выводит результат.
     *
     * @param fileName Имя файла в resources (например, "input.txt")
     */
    public void processResourceFile(String fileName) {
        // Получаем InputStream файла из ресурсов
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {

            if (is == null) {
                System.err.println("Файл не найден: " + fileName);
                return;
            }

            // Читаем файл построчно
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                System.out.println("========== УРОК 8. Маскирование. ==========");
                String line;
                while ((line = reader.readLine()) != null) {
                    // Прогоняем строку через парсер
                    String maskedLine = parser.mask(line);
                    // Выводим результат
                    System.out.println(maskedLine);
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
