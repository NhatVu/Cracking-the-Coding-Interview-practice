package org.example.chap2LinkedList;

import java.io.InputStream;

/*
Return kth element to (or from) the last element
example:
we have defined k such that passing ink = 1 would return the last element, k
2 would return to the second to last element, and so on.

https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
 */
public class Ex2_2_Return_Kth_To_The_Last {
    public static void main(String[] args) {
        int[] input = {10, 5, 100, 5};

        Ex2_2_Return_Kth_To_The_Last solution = new Ex2_2_Return_Kth_To_The_Last();
        Node head = Utils.createLinkedList(input);
        int res = solution.getKthFromLast_recursive(head, 4);
        System.out.println(res);
    }

    /*
    LinkedList: 10->5->100->5, k = 2
    result: 100
     */
    int getKthFromLast(Node head, int k) {
        // Your code here
        Node fast = head;
        Node slow = head;

        int i = 0;
        while (i < k){
            if(fast == null){
                // out of boundary
                return -1;
            }

            fast = fast.next;
            i++;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }

    // recursive approach
    /*
    Recursive Approach Idea:
    - You recursively go to the end of the list.
    - As the recursion unwinds, you keep a counter of how many nodes you've moved back from the end.
    - When the counter reaches k, you record the node.
     */
    int getKthFromLast_recursive(Node head, int k) {
        Result result = new Result();
        helper(head, k , result);
        return result.value;
    }

    void helper(Node head, int k, Result result){
        if(head == null){
            return;
        }

        helper(head.next, k, result);
        result.count++;

        if(result.count == k){
            result.value = head.data;
        }

    }

    static class Result {
        int count = 0;
        int value = -1;
    }
}
