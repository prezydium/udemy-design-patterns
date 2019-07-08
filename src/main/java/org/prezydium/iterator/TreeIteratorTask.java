package org.prezydium.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeIteratorTask {
}

class Node<T> {
    public T value;
    public Node<T> left, right, parent;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;

        left.parent = right.parent = this;
    }

    public Iterator<Node<T>> preOrder() {
        ArrayList<Node<T>> nodes = new ArrayList<>();
        traverseTree(this, nodes);
        return nodes.iterator();
    }

    private List<Node<T>> traverseTree(Node<T> node, List<Node<T>> listOfNodes) {
        listOfNodes.add(node);
        if (node.left != null) {
            traverseTree(node.left, listOfNodes);
        }
        if (node.right != null) {
            traverseTree(node.right, listOfNodes);
        }
        return listOfNodes;
    }
}
