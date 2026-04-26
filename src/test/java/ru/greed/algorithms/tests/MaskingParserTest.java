package ru.greed.algorithms.tests;

import org.junit.jupiter.api.Test;
import ru.greed.algorithms.lesson.eighth.MaskingParser;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaskingParserTest {

    private final MaskingParser parser = new MaskingParser();

    // Набор тестов для логина
    @Test
    void login_short() {
        assertEquals("login=a****", parser.mask("login=admin"));
    }

    @Test
    void login_exactly7() {
        assertEquals("login=r******", parser.mask("login=romanow"));
    }

    @Test
    void login_long() {
        assertEquals("login=te***n", parser.mask("login=testadmin"));
    }

    @Test
    void multiple_logins() {
        String input = "login=romanow login=romanow2";
        String expected = "login=r****** login=ro***2";
        assertEquals(expected, parser.mask(input));
    }

    // Набор тестов для e-mail
    @Test
    void email_basic() {
        assertEquals(
                "email=r***@example.com",
                parser.mask("email=romanow@example.com")
        );
    }

    @Test
    void multiple_emails() {
        String input = "email=a@test.com email=b@test.com";
        String expected = "email=a***@test.com email=b***@test.com";
        assertEquals(expected, parser.mask(input));
    }

    // Набор тестов для ФИО
    @Test
    void name_two_parts() {
        String input = "name=Петров Сергей";
        String expected = "name=П***** Сергей";
        assertEquals(expected, parser.mask(input));
    }

    @Test
    void name_three_parts() {
        String input = "name=Иванов Иван Петрович";
        String expected = "name=И***** Иван Пе***ч";
        assertEquals(expected, parser.mask(input));
    }

    @Test
    void name_in_middle_of_line() {
        String input = "INFO name=Гогия Владимир email=test@test.com";
        String expected = "INFO name=Г**** Владимир email=t***@test.com";
        assertEquals(expected, parser.mask(input));
    }

    // Набор тестов для карт
    @Test
    void card_basic() {
        String input = "card=4111 1111 1111 1234";
        String expected = "card=4111 11** **** 1234";
        assertEquals(expected, parser.mask(input));
    }

    @Test
    void multiple_cards() {
        String input = "card=4111 1111 1111 1234 card=5555 4444 3333 2222";
        String expected = "card=4111 11** **** 1234 card=5555 44** **** 2222";
        assertEquals(expected, parser.mask(input));
    }

    // Комбо-тесты
    @Test
    void mixed_fields_order() {
        String input = "card=4111 1111 1111 1234 login=romanow email=romanow@example.com";
        String expected = "card=4111 11** **** 1234 login=r****** email=r***@example.com";
        assertEquals(expected, parser.mask(input));
    }

    @Test
    void repeated_mixed_fields() {
        String input = "login=admin email=admin@test.com login=testadmin";
        String expected = "login=a**** email=a***@test.com login=te***n";
        assertEquals(expected, parser.mask(input));
    }

    // Отсутсвие групп для маскирования
    @Test
    void no_sensitive_data() {
        String input = "INFO nothing to hide here";
        assertEquals(input, parser.mask(input));
    }

    // Полный тест
    @Test
    void full_test() throws Exception {
        String input = readResource("input.txt");
        String expected = readResource("expected.txt");

        String masked = parser.mask(input);

        assertEquals(expected, masked);
    }

    private String readResource(String name) throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(name)) {
            if (is == null) {
                throw new RuntimeException("Resource not found: " + name);
            }
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
