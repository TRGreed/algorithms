package ru.greed.algorithms.lesson.ninth.operation.maker.impl;

import ru.greed.algorithms.lesson.ninth.context.ApplicationContext;
import ru.greed.algorithms.lesson.ninth.DataReader;
import ru.greed.algorithms.lesson.ninth.Model;
import ru.greed.algorithms.lesson.ninth.Printer;
import ru.greed.algorithms.lesson.ninth.operation.Operation;
import ru.greed.algorithms.lesson.ninth.operation.maker.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OperationMaker implements Component {
    private Supplier<Model> dataReader;
    private Consumer<Model> printer;
    private final Map<String, Operation> operations = new HashMap<>();

    @Override
    public void init(ApplicationContext context) {
        // Вытягиваем зависимости
        this.dataReader = context.get(DataReader.class);
        this.printer = context.get(Printer.class);

        // Вытягиваем все доступные в системе операции
        for (Operation op : context.getAll(Operation.class)) {
            operations.put(op.getSymbol(), op);
        }
    }

    public void make() {
        Model model = dataReader.get();
        Operation operation = operations.get(model.operation);

        if (operation == null) {
            System.out.println("Ошибка: операция '" + model.operation + "' не поддерживается.");
            return;
        }

        model.res = operation.apply(model.x, model.y);
        printer.accept(model);
    }
}

