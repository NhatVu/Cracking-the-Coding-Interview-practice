package org.example.chap2LinkedList;

import java.util.HashSet;
import java.util.Set;

/*
The task is to remove duplicate elements from this unsorted Linked List
 */
public class Ex2_1_Remove_Dup {
    public static void main(String[] args) {
        /*
        5->2->4->2
         */
        int[] input = {5,2,4,2,2,4,6};
//        input = new int[]{2,2,2,2,2};
        Node head = Utils.createLinkedList(input);

        Ex2_1_Remove_Dup solution = new Ex2_1_Remove_Dup();
        Node removeDup = solution.removeDuplicates(head);
        Utils.printList(removeDup);
    }

    public Node removeDuplicates(Node head){
        Set<Integer> set = new HashSet<>();
        Node current = head;
        Node prev = null;

        while(current != null){
            if(!set.contains(current.data)){
                set.add(current.data);
                prev = current;
            }else{
                // duplicated, skip current node
                prev.next = current.next;
            }
            current = current.next;
        }
        return head;
    }
}
