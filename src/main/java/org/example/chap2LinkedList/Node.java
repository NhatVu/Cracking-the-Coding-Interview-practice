package org.example.chap2LinkedList;

public class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
