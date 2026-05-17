package ru.greed.algorithms.lesson.eleventh;

import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;

public class EleventhLessonService {

    public void printResult() {

        List<Integer> original = new LinkedList<>(List.of(3, 4, 5));

        AddCounterHandler handler = new AddCounterHandler(original);

        @SuppressWarnings("unchecked")
        List<Integer> proxyList = (List<Integer>) Proxy.newProxyInstance(
                List.class.getClassLoader(),
                new Class[]{List.class},
                handler
        );

        Magic.test(proxyList);

        System.out.println("Вызовы addFirst: " + handler.getAddFirstCount());
    }
}
