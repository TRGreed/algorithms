package ru.greed.algorithms.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.greed.algorithms.lesson.ninth.context.ApplicationContext;
import ru.greed.algorithms.lesson.ninth.operation.Operation;
import ru.greed.algorithms.lesson.ninth.operation.impl.AdditionOperation;
import ru.greed.algorithms.lesson.ninth.operation.impl.SubtractionOperation;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextTest {

    @Test
    @DisplayName("Контекст должен находить объекты по интерфейсу")
    void testGetByInterface() {
        ApplicationContext context = new ApplicationContext();
        context.register(new AdditionOperation());

        Operation operation = context.get(Operation.class);

        assertNotNull(operation);
        assertEquals("+", operation.getSymbol());
    }

    @Test
    @DisplayName("Контекст должен возвращать все объекты определенного типа")
    void testGetAll() {
        ApplicationContext context = new ApplicationContext();
        context.register(new AdditionOperation());
        context.register(new SubtractionOperation());

        List<Operation> operationList = context.getAll(Operation.class);

        assertEquals(2, operationList.size());
    }
}

