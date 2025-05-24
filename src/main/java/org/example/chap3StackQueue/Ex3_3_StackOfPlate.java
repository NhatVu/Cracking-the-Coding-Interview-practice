package org.example.chap3StackQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
correct but not optimal solution
https://leetcode.com/problems/dinner-plate-stacks/description/
 */
public class Ex3_3_StackOfPlate {

    // list of stack, will push value from index 0
    List<Deque<Integer>> stackList = new ArrayList<>();
    int stackThreshold;

    public Ex3_3_StackOfPlate(int stackThreshold){
        this.stackThreshold = stackThreshold;
    }

    public void push(int value){
        if(stackList.isEmpty()){
            Deque<Integer> deque = new ArrayDeque<>();
            deque.addLast(value);
            stackList.add(deque);
        }else{
            for(int i = 0; i < stackList.size(); i++){
                if(stackList.get(i).size() < stackThreshold){
                    stackList.get(i).addLast(value);
                    return;
                }
            }

            Deque<Integer> deque = new ArrayDeque<>();
            deque.addLast(value);
            stackList.add(deque);
        }
    }

    public int pop(){
        if(stackList.isEmpty()){
            return -1;
        }

        int lastIndex = stackList.size() - 1;
        int res = -1;
        for(int i = lastIndex; i >= 0; i--){
             res = popAtStack(i);
            if(res != - 1){
                break;
            }

            stackList.remove(i);
        }
        return res;
    }

    public int popAtStack(int index){
        if(index >= stackList.size()){
            return -1;
        }

        Deque<Integer> deque = stackList.get(index);
        if(deque.isEmpty()){
            return -1;
        }
        return deque.pollLast();
    }

    public static void main(String[] args) {
        Ex3_3_StackOfPlate D = new Ex3_3_StackOfPlate(2);  // Initialize with capacity = 2
        D.push(1);
        D.push(2);
        D.push(3);
        D.push(4);
        D.push(5);         // The stacks are now:     2  4
                                           //               1  3  5

        System.out.println(D.popAtStack(0));   // Returns 2.  The stacks are now:           4
                                                                                            // 1  3  5

        D.push(20);        // The stacks are now: 20  4
                                                    //  1  3  5

        D.push(21);        // The stacks are now: 20  4 21
                                                    //  1  3  5

        System.out.println(D.popAtStack(0));   // Returns 20.  The stacks are now:      4 21
                                                                                        // 1  3  5

        System.out.println(D.popAtStack(2));   // Returns 21.  The stacks are now:      4
                                                                                        // 1  3  5

        System.out.println(D.pop());            // Returns 5.  The stacks are now:      4
                                                                                //  1   3

        System.out.println(D.pop());            // Returns 4.  The stacks are now:   1  3

        System.out.println(D.pop());            // Returns 3.  The stacks are now:   1

        System.out.println(D.pop());            // Returns 1.  There are no stacks.
        System.out.println(D.pop());            // Returns -1.  There are still no stacks.
    }
}
