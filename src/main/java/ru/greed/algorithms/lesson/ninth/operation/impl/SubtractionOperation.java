package ru.greed.algorithms.lesson.ninth.operation.impl;

import ru.greed.algorithms.lesson.ninth.operation.Operation;

public class SubtractionOperation implements Operation {

    @Override
    public String getSymbol() {
        return "-";
    }

    @Override
    public Integer apply(Integer x, Integer y) {
        return x - y;
    }
}
