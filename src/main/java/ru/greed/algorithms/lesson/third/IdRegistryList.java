package ru.greed.algorithms.lesson.third;

import org.springframework.util.ObjectUtils;
import ru.greed.algorithms.model.RegistryNode;

import java.util.HashMap;
import java.util.Map;

public class IdRegistryList<T> {
    private RegistryNode<T> head;
    private RegistryNode<T> tail;
    private long idCounter = 0;
    private final Map<Long, RegistryNode<T>> registry = new HashMap<>();

    private long register(RegistryNode<T> node) {
        registry.put(node.getId(), node);
        return node.getId();
    }

    public void addFirst(T value) {
        RegistryNode<T> addedNode = new RegistryNode<>(idCounter++, value);

        if (head == null) {
            head = tail = addedNode;
        } else {
            addedNode.setNext(head);
            head.setPrev(addedNode);
            head = addedNode;
        }

        register(addedNode);
    }

    public long addLast(T value) {
        RegistryNode<T> addedNode = new RegistryNode<>(idCounter++, value);

        if (tail == null) {
            head = tail = addedNode;
        } else {
            addedNode.setPrev(tail);
            tail.setNext(addedNode);
            tail = addedNode;
        }
        return register(addedNode);
    }

    public void insertAfter(long positionId, T value) {
        RegistryNode<T> targetNode = registry.get(positionId);

        if (targetNode == null) throw new IllegalArgumentException("Invalid ID");

        if (targetNode == tail) addLast(value);

        RegistryNode<T> addedNode = new RegistryNode<>(idCounter++, value);
        addedNode.setNext(targetNode.getNext());
        addedNode.setPrev(targetNode);
        targetNode.getNext().setPrev(addedNode);
        targetNode.setNext(addedNode);

        register(addedNode);
    }

    public void remove(long positionId) {
        RegistryNode<T> nodeForRemove = registry.remove(positionId);

        if (nodeForRemove == null) return;

        if (nodeForRemove.getPrev() != null) {
            nodeForRemove.getPrev().setNext(nodeForRemove.getNext());
        } else {
            head = nodeForRemove.getNext();
        }

        if (nodeForRemove.getNext() != null) {
            nodeForRemove.getNext().setPrev(nodeForRemove.getPrev());
        } else {
            tail = nodeForRemove.getPrev();
        }
    }

    public T getValue(long positionId) {
        RegistryNode<T> node = registry.get(positionId);

        return (node != null) ? node.getValue() : null;
    }

    public void setValue(long positionId, T value) {
        RegistryNode<T> node = registry.get(positionId);

        if (node != null) node.setValue(value);
    }

    public Long findByValue(T value) {
        RegistryNode<T> current = head;

        while (current != null) {
            if (ObjectUtils.nullSafeEquals(current.getValue(), value)) {
                return current.getId();
            }
            current = current.getNext();
        }
        return null;
    }

    public void printAll() {
        RegistryNode<T> currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.getValue() + " (id:" + currentNode.getId() + ") -> ");
            currentNode = currentNode.getNext();
        }
        System.out.println("FIN");
    }
}

