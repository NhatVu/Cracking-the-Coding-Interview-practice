package org.example.chap2LinkedList;

/*
https://leetcode.com/problems/palindrome-linked-list/description/
 */

public class Ex2_6_Palindrome {
    public static void main(String[] args) {
        int[] x = {1,2,2,1};

        x = new int[]{1,1,2,1};


        Ex2_6_Palindrome solution = new Ex2_6_Palindrome();
        Node headX = Utils.createLinkedList(x);
        boolean isPalindrome = solution.isPalindrome(headX);
        System.out.println(isPalindrome);
    }

    /*
    To determine whether a singly linked list is a palindrome in O(n) time and O(1) space,
    you can use the fast and slow pointer technique to find the middle of the list,
    reverse the second half,
    and then compare both halves.
     */
    public boolean isPalindrome(Node head) {

        // Step 1: Find the end of first half using slow and fast pointers
        Node fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node reverseHead = reverseList(slow);
        while(reverseHead != null && head != null){
            if(reverseHead.data != head.data){
                return false;
            }
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return true;
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
