package com.coffeeisoxygen.classes.nodes;

public abstract class BaseNode<T> {

    private int id;
    private T data;

    protected BaseNode(T data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public abstract BaseNode<T> getNext();
    public abstract void setNext(BaseNode<T> next);
}
