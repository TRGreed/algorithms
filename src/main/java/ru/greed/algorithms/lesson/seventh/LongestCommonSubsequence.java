package ru.greed.algorithms.lesson.seventh;

import java.util.*;

public class LongestCommonSubsequence {

    public static List<String> find(String first, String second) {
        int firstLength = first.length();
        int secondLength = second.length();

        // Создаем таблицу длин
        int[][] matrix = new int[firstLength + 1][secondLength + 1];

        for (int i = 1; i <= firstLength; i++) {
            for (int j = 1; j <= secondLength; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        Set<String> lcsSet = new HashSet<>();
        if (matrix[firstLength][secondLength] > 0) {
            recursiveAssembly(matrix, first, second, firstLength, secondLength, "", lcsSet);
        } else {
            lcsSet.add("");
        }

        List<String> result = new ArrayList<>(lcsSet);
        Collections.sort(result);
        return result;
    }

    private static void recursiveAssembly(int[][] matrix, String first, String second, int firstLength, int secondLength, String current, Set<String> lcsSet) {
        if (firstLength == 0 || secondLength == 0) {
            lcsSet.add(new StringBuilder(current).reverse().toString());
            return;
        }

        if (first.charAt(firstLength - 1) == second.charAt(secondLength - 1)) {
            // Символы совпали — идем по диагонали
            recursiveAssembly(matrix, first, second, firstLength - 1, secondLength - 1, current + first.charAt(firstLength - 1), lcsSet);
        } else {
            int up = matrix[firstLength - 1][secondLength];
            int left = matrix[firstLength][secondLength - 1];

            // Идем только туда, где сохраняется максимальное значение длины
            if (up > left) {
                recursiveAssembly(matrix, first, second, firstLength - 1, secondLength, current, lcsSet);
            } else if (left > up) {
                recursiveAssembly(matrix, first, second, firstLength, secondLength - 1, current, lcsSet);
            } else {
                // Если значения равны — идем в обе стороны
                recursiveAssembly(matrix, first, second, firstLength - 1, secondLength, current, lcsSet);
                recursiveAssembly(matrix, first, second, firstLength, secondLength - 1, current, lcsSet);
            }
        }
    }
}
