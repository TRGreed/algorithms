package ru.greed.algorithms.lesson.eighth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskingParser {

    // Регулярки для поиска полей
    private static final Pattern LOGIN_PATTERN = Pattern.compile("login=(\\S+)");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("email=(\\S+)");
    private static final Pattern NAME_PATTERN = Pattern.compile("name=([^\\n]+?)(?=\\s(?:login=|email=|card=)|$)");
    private static final Pattern CARD_PATTERN = Pattern.compile("card=(\\d{4} \\d{4} \\d{4} \\d{4})");

    public String mask(String input) {
        String result = input;

        // Маскирование по каждому правилу
        result = maskLogins(result);
        result = maskEmails(result);
        result = maskNames(result);
        result = maskCards(result);

        return result;
    }

    // Маскирование логинов
    private String maskLogins(String inputString) {
        Matcher matcher = LOGIN_PATTERN.matcher(inputString);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            String login = matcher.group(1);
            String masked = maskLogin(login);
            matcher.appendReplacement(sb, "login=" + masked);
        }

        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * Если длина строки <= 7, тогда символы, кроме первого, заменяются на *
     * Если длина строки > 7, тогда берётся первый, второй и последний символ, остальное заменяется на ***
     */
    private String maskLogin(String login) {
        if (login.length() <= 7) {
            return login.charAt(0) + "*".repeat(login.length() - 1);
        } else {
            return "" + login.charAt(0)
                    + login.charAt(1)
                    + "***"
                    + login.charAt(login.length() - 1);
        }
    }

    // Маскирование e-mail
    private String maskEmails(String inputString) {
        Matcher matcher = EMAIL_PATTERN.matcher(inputString);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            String email = matcher.group(1);
            String masked = maskEmail(email);
            matcher.appendReplacement(sb, "email=" + masked);
        }

        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * Все символы до @ заменяются на первый символ + ***
     */
    private String maskEmail(String email) {
        int atIndex = email.indexOf('@');
        String name = email.substring(0, atIndex);
        String domain = email.substring(atIndex);

        return name.charAt(0) + "***" + domain;
    }

    // Маскирование ФИО
    private String maskNames(String inputString) {
        Matcher matcher = NAME_PATTERN.matcher(inputString);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            String fullName = matcher.group(1);
            String masked = maskFullName(fullName.trim());
            matcher.appendReplacement(sb, "name=" + masked);
        }

        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * Если длина фамилии и отчества <= 7, тогда символы, кроме первого, заменяются на *
     * Если длина фамилии и отчества > 7, тогда берётся первый, второй и последний символ, остальное заменяется на ***
     * Имя (оно идёт всегда вторым) не маскируется
     */
    private String maskFullName(String fullName) {
        String[] parts = fullName.split(" ");

        // Фамилия
        parts[0] = maskLogin(parts[0]);

        // Имя НЕ маскируется (parts[1])

        // Отчество
        if (parts.length > 2) {
            parts[2] = maskLogin(parts[2]);
        }

        return String.join(" ", parts);
    }

    // Маскирование карт
    private String maskCards(String inputString) {
        Matcher matcher = CARD_PATTERN.matcher(inputString);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            String card = matcher.group(1);
            String masked = maskCard(card);
            matcher.appendReplacement(sb, "card=" + masked);
        }

        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * Отображаются первые шесть и последние четыре цифры номера
     */
    private String maskCard(String card) {
        String[] parts = card.split(" ");

        return parts[0] + " " +
                parts[1].substring(0, 2) + "**" + " " +
                "****" + " " +
                parts[3];
    }
}