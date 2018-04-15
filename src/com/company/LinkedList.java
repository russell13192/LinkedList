package com.company;

public class LinkedList<T extends Comparable<T>> implements List<T>{

    private Node<T> root;
    private int sizeOfList;

    @Override
    public void insert(T data) {
        ++this.sizeOfList;

        if (root == null) {
            this.root = new Node<>(data);
        } else {
            insertDataAtBeginning(data);
        }
    }
    // Constant Time Complexity O(1)
    private void insertDataAtBeginning(T data) {
        // Create new node for LinkedList data structure
        Node<T> newNode = new Node<>(data);
        // Set inserted nodes pointer to the root of the LinkedList thereby making inserted node the new root.
        newNode.setNextNode(root);
        // Set LinkedList data structure root attribute to newly inserted node
        this.root = newNode;
    }
    // Linear Time Complexity O(N)
    private void insertDataAtEnd(T data, Node<T> node) {
        if (node.getNextNode() != null) { // Means we are not at the end of the LinkedList data structure
            insertDataAtEnd(data, node.getNextNode());
        } else { // Means we are at the end of the LinkedList data structure
            Node<T> newNode = new Node<>(data); // Create new node
            node.setNextNode(newNode); // Point to that node we just created

        }
    }

    @Override
    public void remove(T data) {
        if (this.root == null) {
            return;
        }
        --this.sizeOfList;
        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {
        while (actualNode != null) {
            if (actualNode.getData().compareTo(dataToRemove) == 0) {
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverseList() {
        if (this.root == null) {
            return;
        }
        Node<T> actualNode = this.root;
        while (actualNode != null) {
            System.out.print(actualNode + " -> ");
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return this.sizeOfList;
    }
}
