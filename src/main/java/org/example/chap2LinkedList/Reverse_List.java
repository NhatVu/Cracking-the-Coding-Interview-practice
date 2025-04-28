package org.example.chap2LinkedList;

public class Reverse_List {
    public static void main(String[] args) {
        int[] x = {1,2,3};


        Reverse_List solution = new Reverse_List();
        Node headX = Utils.createLinkedList(x);
        Node newHead = solution.reverseList(headX);

        Utils.printList(newHead);
    }

    public Node reverseList(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
