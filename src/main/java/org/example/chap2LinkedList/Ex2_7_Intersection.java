package org.example.chap2LinkedList;

import java.util.HashSet;
import java.util.Set;

/*
https://www.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/
 */
public class Ex2_7_Intersection {
    public static void main(String[] args) {
        int[] x = new int[]{1,1,2,1};


        Ex2_6_Palindrome solution = new Ex2_6_Palindrome();
        Node headX = Utils.createLinkedList(x);
    }

    public Node intersectPoint(Node head1, Node head2) {
        // code here
        Set<Node> set1 = new HashSet<>();
        Node i = head1;
        while(i != null){
            set1.add(i);
            i = i.next;
        }

        i = head2;
        while(i != null){
            if(set1.contains(i)){
                return i;
            }
            i = i.next;
        }
        return null;

    }
}
