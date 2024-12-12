package com.coffeeisoxygen.classes.nodes;

public class DoublyNode<T> extends SingleNode<T> {
    private DoublyNode<T> prev;

    public DoublyNode(T data) {
        super(data);
        this.prev = null;
    }

    public DoublyNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyNode<T> prev) {
        this.prev = prev;
    }
}
