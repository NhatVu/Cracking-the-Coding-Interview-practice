package org.example.chap2LinkedList;

/*
https://leetcode.com/problems/add-two-numbers/description/

https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-list/
 */
public class Ex2_5_Sum_List {
    public static void main(String[] args) {
        int[] x = {7, 1, 6};
        int[] y = {2, 9, 5};


        Ex2_5_Sum_List solution = new Ex2_5_Sum_List();
        Node headX = Utils.createLinkedList(x);
        Node headY = Utils.createLinkedList(y);

        Node res = solution.addTwoNumbers(headX, headY);
        Utils.printList(res);
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node res = new Node(0);
        Node it = res;

        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int val1 = l1 != null ? l1.data: 0;
            int val2 = l2 != null ? l2.data: 0;
            int tmp = val1 + val2 + carry;
            int val = tmp % 10;
            carry = tmp/10;

            it.next = new Node(val);
            it = it.next;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        return res.next;

    }
}
