package ru.greed.algorithms.lesson.eleventh;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

class AddCounterHandler implements InvocationHandler {

    private final List<Integer> target;

    private int addFirstCount = 0;

    public AddCounterHandler(List<Integer> target) {
        this.target = target;
    }

    public int getAddFirstCount() {
        return addFirstCount;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("addFirst".equals(method.getName())) {
            addFirstCount++;
        }
        return method.invoke(target, args);
    }
}
