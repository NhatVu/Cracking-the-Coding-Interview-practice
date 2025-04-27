package org.example.chap2LinkedList;

/*
https://www.geeksforgeeks.org/in-a-linked-list-given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/

https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class Ex2_3_Delete_Middle_Node {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};

        Ex2_3_Delete_Middle_Node solution = new Ex2_3_Delete_Middle_Node();
        Node head = Utils.createLinkedList(input);
    }

    /*
    Input: LinkedList: 1->2->3->4->5, delete_ptr = 2
    Output: LinkedList: 1->3->4->5
     */
    public void deleteNode(Node node) {
        if(node == null || node.next == null)
        {
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
