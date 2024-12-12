package com.coffeeisoxygen.classes.nodes;

public class NodeFactory {

    public enum NodeType {
        SINGLE,
        DOUBLY
    }

    public static <T> BaseNode<T> createNode(NodeType type, T data) {
        if (type == null) {
            throw new IllegalArgumentException("Node type cannot be null");
        }
        switch (type) {
            case SINGLE -> {
                return new SingleNode<>(data);
            }
            case DOUBLY -> {
                return new DoublyNode<>(data);
            }
            default -> throw new IllegalArgumentException("Invalid node type");
        }
    }
}
