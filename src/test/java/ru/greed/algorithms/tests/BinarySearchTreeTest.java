package ru.greed.algorithms.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.greed.algorithms.lesson.sixth.BinarySearchTree;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer, String> tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<>();
    }

    @Test
    void testInsertAndSearch() {
        tree.insert(10, "десять");
        tree.insert(5, "пять");
        tree.insert(15, "пятнадцать");

        assertEquals("десять", tree.search(10));
        assertEquals("пять", tree.search(5));
        assertEquals("пятнадцать", tree.search(15));
    }

    @Test
    void testUpdateExistingKey() {
        tree.insert(10, "старое значение");
        tree.insert(10, "новое значение");

        assertEquals("новое значение", tree.search(10));
    }

    @Test
    void testSearchNonExistentKey() {
        tree.insert(10, "десять");
        assertNull(tree.search(100), "Должен возвращать null, если ключ не найден");
    }

    @Test
    void testRemoveLeafNode() {
        tree.insert(10, "корень");
        tree.insert(5, "лист");

        String removedValue = tree.remove(5);

        assertEquals("лист", removedValue);
        assertNull(tree.search(5), "Лист должен быть удален");
    }

    @Test
    void testRemoveNodeWithOneChild() {
        tree.insert(10, "корень");
        tree.insert(5, "родитель");
        tree.insert(2, "ребенок");

        String removedValue = tree.remove(5);

        assertEquals("родитель", removedValue);
        assertEquals("ребенок", tree.search(2), "Ребенок должен остаться в дереве");
        assertNull(tree.search(5));
    }

    @Test
    void testRemoveNodeWithTwoChildren() {
        tree.insert(10, "корень");
        tree.insert(5, "узел");
        tree.insert(3, "левый");
        tree.insert(7, "правый");

        String removedValue = tree.remove(5);

        assertEquals("узел", removedValue);
        assertNull(tree.search(5));
        assertEquals("левый", tree.search(3));
        assertEquals("правый", tree.search(7));
    }

    @Test
    void testRemoveRoot() {
        tree.insert(10, "корень");
        tree.insert(5, "лево");
        tree.insert(15, "право");

        String removedValue = tree.remove(10);

        assertEquals("корень", removedValue);
        assertNull(tree.search(10));
        assertEquals("лево", tree.search(5));
        assertEquals("право", tree.search(15));
    }

    @Test
    void testRemoveNonExistentKey() {
        tree.insert(10, "значение");
        assertNull(tree.remove(99), "Должен возвращать null при попытке удалить несуществующий ключ");
    }
}
