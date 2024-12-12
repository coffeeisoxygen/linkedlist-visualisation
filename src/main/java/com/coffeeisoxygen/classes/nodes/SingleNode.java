package com.coffeeisoxygen.classes.nodes;

public class SingleNode<T> extends BaseNode<T> {
    private SingleNode<T> next;

    public SingleNode(T data) {
        super(data);
        this.next = null;
    }

    @Override
    public SingleNode<T> getNext() {
        return next;
    }

    @Override
    public void setNext(BaseNode<T> next) {
        this.next = (SingleNode<T>) next;
    }
}
