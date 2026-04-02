package ru.greed.algorithms.lesson.third;

import ru.greed.algorithms.model.RegistryNode;

import java.util.Objects;

public class CustomLinkedList<T> {

    private RegistryNode<T> head;
    private RegistryNode<T> tail;

    public RegistryNode<T> addFirst(T value) {
        RegistryNode<T> newNode = new RegistryNode<>(value);
        if (head == null) {
            tail = head = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        return newNode;
    }

    public RegistryNode<T> addLast(T value) {
        RegistryNode<T> newNode = new RegistryNode<>(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        return newNode;
    }

    public RegistryNode<T> insertAfter(RegistryNode<T> position, T value) {
        if (position == null) return addLast(value);

        RegistryNode<T> newNode = new RegistryNode<>(value);
        newNode.setNext(position.getNext());
        newNode.setPrev(position);

        if (position.getNext() != null) {
            position.getNext().setPrev(newNode);
        } else {
            tail = newNode;
        }
        position.setNext(newNode);

        return newNode;
    }

    public RegistryNode<T> insertBefore(RegistryNode<T> position, T value) {
        if (position == null) return addFirst(value);

        RegistryNode<T> newNode = new RegistryNode<>(value);
        newNode.setPrev(position.getPrev());
        newNode.setNext(position);

        if (position.getPrev() != null) {
            position.getPrev().setNext(newNode);
        } else {
            head = newNode;
        }
        position.setPrev(newNode);

        return newNode;
    }

    public void remove(RegistryNode<T> node) {
        if (node == null) return;

        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            head = node.getNext();
        }

        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            tail = node.getPrev();
        }

        node.setNext(null);
        node.setPrev(null);
    }

    public RegistryNode<T> find(T value) {
        RegistryNode<T> current = head;
        while (current != null) {
            if (Objects.equals(current.getValue(), value)) return current;
            current = current.getNext();
        }
        return null;
    }

    public void printAll() {
        RegistryNode<T> currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.getValue() + " -> ");
            currentNode = currentNode.getNext();
        }
        System.out.println("FIN");
    }
}