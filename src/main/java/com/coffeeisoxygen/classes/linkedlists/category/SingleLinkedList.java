package com.coffeeisoxygen.classes.linkedlists.category;

import com.coffeeisoxygen.classes.linkedlists.LinkedList;
import com.coffeeisoxygen.classes.nodes.BaseNode;
import com.coffeeisoxygen.classes.nodes.NodeFactory;
import com.coffeeisoxygen.classes.nodes.NodeFactory.NodeType;
import com.coffeeisoxygen.classes.nodes.SingleNode;

public class SingleLinkedList<T> extends LinkedList<T> {

    @Override
    protected BaseNode<T> createNode(T data) {
        return NodeFactory.createNode(NodeType.SINGLE, data);
    }

    @Override
    protected void addNodeToEnd(BaseNode<T> newNode) {
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            ((SingleNode<T>) tail).setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    protected void addNodeToBeginning(BaseNode<T> newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            ((SingleNode<T>) newNode).setNext(head);
            head = newNode;
        }
    }
}
