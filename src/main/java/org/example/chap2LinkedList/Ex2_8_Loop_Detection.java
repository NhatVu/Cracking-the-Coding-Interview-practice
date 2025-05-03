package org.example.chap2LinkedList;

/*
https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/

https://leetcode.com/problems/linked-list-cycle-ii/description/
 */
public class Ex2_8_Loop_Detection {
    public static void main(String[] args) {

    }

    public Node findFirstNode(Node head) {
        // code here
        Node fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                // Move slow to head, keep fast at meeting point
                slow = head;

                // Move both one step at a time until they meet
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Return the meeting node, which is the
                // start of the loop
                return slow;
            }
        }
        return null;
    }
}
