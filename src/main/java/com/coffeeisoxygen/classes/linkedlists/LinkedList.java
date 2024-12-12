package com.coffeeisoxygen.classes.linkedlists;

import com.coffeeisoxygen.classes.nodes.BaseNode;
import com.coffeeisoxygen.classes.nodes.DoublyNode;

public abstract class LinkedList<T> {
    protected BaseNode<T> head;
    protected BaseNode<T> tail;
    protected int size;
    private int idCounter;

    protected LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.idCounter = 0;
    }

    public BaseNode<T> getHead() {
        return head;
    }

    public BaseNode<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T data) {
        BaseNode<T> newNode = createNode(data);
        newNode.setId(idCounter++);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            addNodeToEnd(newNode);
        }
        size++;
    }

    public void addFirst(T data) {
        BaseNode<T> newNode = createNode(data);
        newNode.setId(idCounter++);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            addNodeToBeginning(newNode);
        }
        size++;
    }

    public void remove(T data) {
        if (head == null)
            return;

        if (head.getData().equals(data)) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            size--;
            updateIds();
            return;
        }

        BaseNode<T> current = head;
        while (current.getNext() != null && !current.getNext().getData().equals(data)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            if (current.getNext() == null) {
                tail = current;
            }
            size--;
            updateIds();
        }
    }

    private void updateIds() {
        BaseNode<T> current = head;
        idCounter = 0;
        while (current != null) {
            current.setId(idCounter++);
            current = current.getNext();
        }
    }

    public BaseNode<T> find(T data) {
        BaseNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
        idCounter = 0;
    }

    public void display() {
        BaseNode<T> current = head;
        while (current != null) {
            System.out.println("Node ID: " + current.getId());
            System.out.println("Data: " + current.getData());
            System.out.println("Next ID: " + (current.getNext() != null ? current.getNext().getId() : "null"));
            if (current instanceof DoublyNode) {
                System.out.println("Prev ID: " + (((DoublyNode<T>) current).getPrev() != null ? ((DoublyNode<T>) current).getPrev().getId() : "null"));
            }
            System.out.println("----------");
            current = current.getNext();
        }
    }

    public void displayCircular(int limit) {
        BaseNode<T> current = head;
        int count = 0;
        while (current != null && count < limit) {
            System.out.println("Node ID: " + current.getId());
            System.out.println("Data: " + current.getData());
            System.out.println("Next ID: " + (current.getNext() != null ? current.getNext().getId() : "null"));
            if (current instanceof DoublyNode) {
                System.out.println("Prev ID: " + (((DoublyNode<T>) current).getPrev() != null ? ((DoublyNode<T>) current).getPrev().getId() : "null"));
            }
            System.out.println("----------");
            current = current.getNext();
            count++;
        }
    }

    // Abstract methods

    protected abstract BaseNode<T> createNode(T data);

    protected abstract void addNodeToEnd(BaseNode<T> newNode);

    protected abstract void addNodeToBeginning(BaseNode<T> newNode);
}
