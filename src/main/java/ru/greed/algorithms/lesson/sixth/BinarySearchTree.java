package ru.greed.algorithms.lesson.sixth;

/**
 * Реализация бинарного дерева поиска.
 * @param <K> Тип ключа, должен быть сравнимым (Comparable).
 * @param <V> Тип значения.
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    // Узел дерева
    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    /**
     * Вставка: если ключ уже есть, значение перезаписывается.
     */
    public void insert(K key, V value) {
        if (key == null) return;
        root = insertRecursive(root, key, value);
    }

    private Node insertRecursive(Node current, K key, V value) {
        // Если дошли до пустой ветки — создаем новый узел
        if (current == null) {
            return new Node(key, value);
        }

        //Сравниваем ключи
        int compareResult = key.compareTo(current.key);

        if (compareResult < 0) {
            // Идем влево
            current.left = insertRecursive(current.left, key, value);
        } else if (compareResult > 0) {
            // Идем вправо
            current.right = insertRecursive(current.right, key, value);
        } else {
            // Ключ совпал — перезаписываем значение
            current.value = value;
        }
        return current;
    }

    /**
     * Поиск: возвращает значение или null, если ключ не найден.
     */
    public V search(K key) {
        return searchRecursive(root, key);
    }

    private V searchRecursive(Node current, K key) {
        // Если дошли до пустой ветки - возвращаем null
        if (current == null) return null;

        //Сравниваем ключи
        int compareResult = key.compareTo(current.key);

        // Ключ совпал — возвращаем значение
        if (compareResult == 0) return current.value;

        // Идем влево или вправо в зависимости от результата сравнения
        return compareResult < 0 ? searchRecursive(current.left, key) : searchRecursive(current.right, key);
    }

    /**
     * Удаление: удаляет узел и возвращает старое значение.
     * Если ключа нет — возвращает null.
     */
    public V remove(K key) {
        // Сначала найдем значение, чтобы вернуть его согласно условию
        V oldValue = search(key);

        if (oldValue != null) {
            root = removeRecursive(root, key);
        }
        return oldValue;
    }

    private Node removeRecursive(Node current, K key) {
        if (current == null) return null;

        int compareResult = key.compareTo(current.key);
        if (compareResult < 0) {
            current.left = removeRecursive(current.left, key);
        } else if (compareResult > 0) {
            current.right = removeRecursive(current.right, key);
        } else {
            // Узел найден — обрабатываем 3 случая удаления

            // 1. У узла нет детей или один ребенок
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            // 2. У узла два ребенка: ищем преемника (минимум в правом поддереве)
            Node successor = findMin(current.right);
            current.key = successor.key;
            current.value = successor.value;

            // Удаляем преемника из правого поддерева
            current.right = removeRecursive(current.right, successor.key);
        }
        return current;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void print() {
        if (root == null) {
            System.out.println("(Дерево пустое)");
            return;
        }
        printRecursive(root, "", true);
    }

    private void printRecursive(Node node, String prefix, boolean isTail) {
        if (node.right != null) {
            printRecursive(node.right, prefix + (isTail ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.key + " (" + node.value + ")");

        if (node.left != null) {
            printRecursive(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }
}
