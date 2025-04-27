package org.example.chap2LinkedList;

/*
https://leetcode.com/problems/partition-list/submissions/

https://www.geeksforgeeks.org/partitioning-a-linked-list-around-a-given-value-and-keeping-the-original-order/
 */
public class Ex2_4_List_Partition {
    public static void main(String[] args) {
        int[] input = {1, 4, 3, 2, 5, 2, 3};
        int x = 3;

        input = new int[] {9, 9, 7, 7, 6, 1, 9, 5, 7, 9, 3};
        x = 7;

        Ex2_4_List_Partition solution = new Ex2_4_List_Partition();
        Node head = Utils.createLinkedList(input);

        Node newHead = solution.partition(head, x);

        Utils.printList(newHead);
    }

    /*
    Input: Linked list: 1->4->3->2->5->2->3, x = 3
Output: 1->2->2->3->3->4->5
     */
    public Node partition(Node node, int x) {
        // Your code here
        Node headLeft = new Node(-1);
        Node left = headLeft;

        Node headRight = new Node(-1);
        Node right = headRight;

        Node headEqual = new Node(-1);
        Node equal = headEqual;

        Node i = node;
        while(i != null){
            if(i.data < x){
                left.next = i;
                left = i;
            }else if (i.data > x){
                right.next = i;
                right = i;
            }else {
                equal.next = i;
                equal = i;
            }
            i = i.next;
        }

        left.next = headEqual.next;
        equal.next = headRight.next;
        right.next = null;

        return headLeft.next;
    }
}
