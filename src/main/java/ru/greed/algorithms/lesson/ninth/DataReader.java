package ru.greed.algorithms.lesson.ninth;

import java.util.Scanner;
import java.util.function.Supplier;

public class DataReader implements Supplier<Model> {

    @Override
    public Model get() {
        Scanner scanner = new Scanner(System.in);
        Model model = new Model();

        System.out.print("Введите операцию (+ или -): ");
        model.operation = scanner.next();

        System.out.print("Введите первое число: ");
        model.x = scanner.nextInt();

        System.out.print("Введите второе число: ");
        model.y = scanner.nextInt();

        return model;
    }
}
