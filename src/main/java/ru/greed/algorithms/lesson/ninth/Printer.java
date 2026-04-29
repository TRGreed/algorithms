package ru.greed.algorithms.lesson.ninth;

import java.util.function.Consumer;

public class Printer implements Consumer<Model> {

    @Override
    public void accept(Model model) {
        System.out.printf("Результат: %d %s %d = %d%n", model.x, model.operation, model.y, model.res);
    }
}
