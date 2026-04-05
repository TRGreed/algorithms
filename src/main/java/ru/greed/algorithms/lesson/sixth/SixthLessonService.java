package ru.greed.algorithms.lesson.sixth;

public class SixthLessonService {

    public void printBinaryTree() {
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();

        // 1. Вставка
        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        for (int key : keys) {
            System.out.println(">>> Вставляем ключ: " + key);
            binarySearchTree.insert(key, "Val-" + key);
            binarySearchTree.print();
            System.out.println("--------------------------");
        }

        // 2. Обновление
        System.out.println("\n>>> ОБНОВЛЕНИЕ: Перезаписываем ключ 50 (Root)");
        binarySearchTree.insert(50, "NEW ROOT");
        binarySearchTree.print();
        System.out.println("--------------------------");

        // 3. Поиск
        System.out.println("\n>>> ПОИСК: Ищем ключ 40");
        String result = binarySearchTree.search(40);
        System.out.println("Результат: " + (result != null ? result : "не найден"));

        // 4. Удаление
        // А) Удаление листа
        System.out.println("\n>>> УДАЛЕНИЕ: Узел 20 (Лист)");
        binarySearchTree.remove(20);
        binarySearchTree.print();
        System.out.println("--------------------------");

        // Б) Удаление узла с одним ребенком
        System.out.println("\n>>> Добавили 85");
        binarySearchTree.insert(85, "Child of 80");
        binarySearchTree.print();
        System.out.println("\n>>> Удаляем 80");
        binarySearchTree.remove(80);
        binarySearchTree.print();
        System.out.println("--------------------------");

        // В) Удаление корня
        binarySearchTree.print();
        System.out.println("\n>>> УДАЛЕНИЕ: КОРЕНЬ (50)");
        binarySearchTree.remove(50);
        binarySearchTree.print();
    }
}
