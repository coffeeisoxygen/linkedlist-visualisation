package com.coffeeisoxygen.classes.linkedlists.category;

import com.coffeeisoxygen.classes.linkedlists.LinkedList;
import com.coffeeisoxygen.classes.nodes.BaseNode;
import com.coffeeisoxygen.classes.nodes.DoublyNode;
import com.coffeeisoxygen.classes.nodes.NodeFactory;
import com.coffeeisoxygen.classes.nodes.NodeFactory.NodeType;

public class DoublyLinkedList<T> extends LinkedList<T> {

    @Override
    protected BaseNode<T> createNode(T data) {
        return NodeFactory.createNode(NodeType.DOUBLY, data);
    }

    @Override
    protected void addNodeToEnd(BaseNode<T> newNode) {
        DoublyNode<T> doublyNewNode = (DoublyNode<T>) newNode;
        if (tail == null) {
            head = doublyNewNode;
            tail = doublyNewNode;
        } else {
            ((DoublyNode<T>) tail).setNext(doublyNewNode);
            doublyNewNode.setPrev((DoublyNode<T>) tail);
            tail = doublyNewNode;
        }
    }

    @Override
    protected void addNodeToBeginning(BaseNode<T> newNode) {
        DoublyNode<T> doublyNewNode = (DoublyNode<T>) newNode;
        if (head == null) {
            head = doublyNewNode;
            tail = doublyNewNode;
        } else {
            doublyNewNode.setNext(head);
            ((DoublyNode<T>) head).setPrev(doublyNewNode);
            head = doublyNewNode;
        }
    }
}
