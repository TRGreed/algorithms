package ru.greed.algorithms.lesson.ninth.operation;

import java.util.function.BinaryOperator;

public interface Operation extends BinaryOperator<Integer> {
    String getSymbol();
}

