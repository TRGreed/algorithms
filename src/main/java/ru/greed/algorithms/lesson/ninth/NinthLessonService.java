package ru.greed.algorithms.lesson.ninth;

import ru.greed.algorithms.lesson.ninth.context.ApplicationContext;
import ru.greed.algorithms.lesson.ninth.operation.impl.AdditionOperation;
import ru.greed.algorithms.lesson.ninth.operation.impl.SubtractionOperation;
import ru.greed.algorithms.lesson.ninth.operation.maker.impl.OperationMaker;

public class NinthLessonService {

    public void mainMethod() {

        ApplicationContext context = new ApplicationContext();

        // Регистрируем компоненты
        context.register(new DataReader());
        context.register(new Printer());
        context.register(new AdditionOperation());
        context.register(new SubtractionOperation());

        // Регистрируем мейкер. При регистрации вызовется init(),
        // и он сам подтянет всё, что ему нужно из контекста.
        OperationMaker maker = new OperationMaker();
        context.register(maker);

        // Запуск логики
        maker.make();
    }
}
