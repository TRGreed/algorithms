package ru.greed.algorithms.lesson.ninth.context;

import ru.greed.algorithms.lesson.ninth.operation.maker.Component;

import java.util.*;

public class ApplicationContext {

    private final Map<Class<?>, Object> registry = new HashMap<>();

    public void register(Object component) {
        // Если компонент требует инициализации, даем ему ссылку на контекст
        if (component instanceof Component) {
            ((Component) component).init(this);
        }
        registry.put(component.getClass(), component);
    }

    public <T> T get(Class<T> type) {
        T exactMatch = type.cast(registry.get(type));
        if (exactMatch != null) {
            return exactMatch;
        }

        // Поиск по интерфейсам
        for (Object obj : registry.values()) {
            if (type.isInstance(obj)) {
                return type.cast(obj);
            }
        }
        throw new NoSuchElementException("Компонент не найден: " + type.getName());
    }

    public <T> List<T> getAll(Class<T> type) {
        List<T> result = new ArrayList<>();
        for (Object obj : registry.values()) {
            if (type.isInstance(obj)) {
                result.add(type.cast(obj));
            }
        }
        return result;
    }
}

