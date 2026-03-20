package ru.greed.algorithms.model;

public class RegistryNode<T> {
    long id;
    T value;
    RegistryNode<T> next, prev;

    public RegistryNode(long id, T value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public T getValue() {
        return value;
    }

    public RegistryNode<T> getNext() {
        return next;
    }

    public RegistryNode<T> getPrev() {
        return prev;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(RegistryNode<T> next) {
        this.next = next;
    }

    public void setPrev(RegistryNode<T> prev) {
        this.prev = prev;
    }
}
