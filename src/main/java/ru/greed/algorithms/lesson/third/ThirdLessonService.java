package ru.greed.algorithms.lesson.third;

import ru.greed.algorithms.model.RegistryNode;

public class ThirdLessonService {

    private final CustomLinkedList<String> list = new CustomLinkedList<>();

    public void printTestList() {
        RegistryNode<String> node1 = list.addLast("First");
        RegistryNode<String> node2 = list.addLast("Second");
        RegistryNode<String> node3 = list.addLast("Third");

        list.printAll();

        list.insertAfter(node2, "Inserted-Between-2-and-3");

        list.printAll();

        node1.setValue("Updated First");

        list.printAll();

        list.addFirst("New First");

        list.printAll();

        list.insertBefore(list.find("New First"), "Zero");

        list.printAll();

        RegistryNode<String> node4 = list.addLast("Fourth");

        list.printAll();

        list.remove(node4);

        list.printAll();

        list.remove(node2);

        list.printAll();
    }
}