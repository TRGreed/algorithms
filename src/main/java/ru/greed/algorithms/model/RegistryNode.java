package ru.greed.algorithms.model;

public class RegistryNode<T> {

    private T value;
    private RegistryNode<T> next;
    private RegistryNode<T> prev;

    public RegistryNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public RegistryNode<T> getNext() {
        return next;
    }

    public void setNext(RegistryNode<T> next) {
        this.next = next;
    }

    public RegistryNode<T> getPrev() {
        return prev;
    }

    public void setPrev(RegistryNode<T> prev) {
        this.prev = prev;
    }
}