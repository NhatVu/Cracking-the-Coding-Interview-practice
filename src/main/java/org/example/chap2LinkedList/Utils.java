package org.example.chap2LinkedList;

public class Utils {
    public static void printList(Node head){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static Node createLinkedList(int[] input){
        Node head = new Node(-1);
        Node i = head;
        for(int value: input){
            i.next = new Node(value);
            i = i.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] input = {5,2,4,2};
        Node head = createLinkedList(input);
        System.out.println("print list");
        printList(head);
    }
}
