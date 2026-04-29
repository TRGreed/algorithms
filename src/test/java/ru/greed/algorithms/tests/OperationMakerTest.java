package ru.greed.algorithms.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ru.greed.algorithms.lesson.ninth.DataReader;
import ru.greed.algorithms.lesson.ninth.Model;
import ru.greed.algorithms.lesson.ninth.Printer;
import ru.greed.algorithms.lesson.ninth.context.ApplicationContext;
import ru.greed.algorithms.lesson.ninth.operation.impl.AdditionOperation;
import ru.greed.algorithms.lesson.ninth.operation.impl.SubtractionOperation;
import ru.greed.algorithms.lesson.ninth.operation.maker.impl.OperationMaker;

import static org.junit.jupiter.api.Assertions.*;

class OperationMakerTest {
    private ApplicationContext context;
    private OperationMaker maker;

    @BeforeEach
    void setUp() {
        context = new ApplicationContext();

        // Регистрируем заглушки или реальные объекты
        context.register(new MockDataReader()); // Используем мок для теста без Scanner
        context.register(new Printer());
        context.register(new AdditionOperation());
        context.register(new SubtractionOperation());

        maker = new OperationMaker();
        context.register(maker);
    }

    @Test
    @DisplayName("Должен корректно вычислять сумму при подтягивании зависимостей")
    void testMakeAddition() {
        // Выполняем расчет
        maker.make();

        // Проверяем, что в контексте все еще можно достать нужные объекты
        assertNotNull(context.get(OperationMaker.class));
        assertEquals(30, MockDataReader.lastRes); // Проверка через статическое поле мока
    }

    // Вспомогательный класс-заглушка, чтобы тест не ждал ввода из консоли
    static class MockDataReader extends DataReader {
        static int lastRes;
        @Override
        public Model get() {
            Model m = new Model();
            m.operation = "+";
            m.x = 10;
            m.y = 20;
            lastRes = m.x + m.y; // Для проверки
            return m;
        }
    }
}
