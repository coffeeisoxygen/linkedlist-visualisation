package com.coffeeisoxygen.classes.linkedlists.category;

import com.coffeeisoxygen.classes.linkedlists.LinkedList;
import com.coffeeisoxygen.classes.nodes.BaseNode;
import com.coffeeisoxygen.classes.nodes.DoublyNode;
import com.coffeeisoxygen.classes.nodes.NodeFactory;
import com.coffeeisoxygen.classes.nodes.NodeFactory.NodeType;

public class CircularDoublyLinkedList<T> extends LinkedList<T> {

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
            doublyNewNode.setNext(doublyNewNode);
            doublyNewNode.setPrev(doublyNewNode);
        } else {
            ((DoublyNode<T>) tail).setNext(doublyNewNode);
            doublyNewNode.setPrev((DoublyNode<T>) tail);
            doublyNewNode.setNext(head);
            ((DoublyNode<T>) head).setPrev(doublyNewNode);
            tail = doublyNewNode;
        }
    }

    @Override
    protected void addNodeToBeginning(BaseNode<T> newNode) {
        DoublyNode<T> doublyNewNode = (DoublyNode<T>) newNode;
        if (head == null) {
            head = doublyNewNode;
            tail = doublyNewNode;
            doublyNewNode.setNext(doublyNewNode);
            doublyNewNode.setPrev(doublyNewNode);
        } else {
            doublyNewNode.setNext(head);
            doublyNewNode.setPrev((DoublyNode<T>) tail);
            ((DoublyNode<T>) head).setPrev(doublyNewNode);
            ((DoublyNode<T>) tail).setNext(doublyNewNode);
            head = doublyNewNode;
        }
    }
}
