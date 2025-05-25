package org.example.chap3StackQueue;

import java.util.*;

/*
correct but not optimal solution
https://leetcode.com/problems/dinner-plate-stacks/description/
 */
public class Ex3_3_StackOfPlate_Optimize {

    // list of stack, will push value from index 0
    List<Deque<Integer>> stackList = new ArrayList<>();
    int capacity;
    TreeSet<Integer> availablePush = new TreeSet<>(); // keep index of stack that available for pushing
    int rightMost = -1; // rightMost position of stack, using for pop

    public Ex3_3_StackOfPlate_Optimize(int capacity){
        this.capacity = capacity;
    }

    public void push(int value){
        int index = availablePush.isEmpty() ? stackList.size() : availablePush.first();

        if(index >= stackList.size()){
            stackList.add(new ArrayDeque<>());
            availablePush.add(index);
        }

        stackList.get(index).addLast(value);
        // check size of stack after added
        if(stackList.get(index). size() >= capacity){
            availablePush.remove(index);
        }

        // udpate rightMost
        rightMost = Math.max(rightMost, index);
    }

    public int pop(){
        while (rightMost >= 0 && (stackList.get(rightMost).isEmpty())){
            rightMost--;
        }

        if(rightMost < 0){
            return -1;
        }

        int val = stackList.get(rightMost).pollLast();

        // update avaiablePush
        availablePush.add(rightMost);
        return val;
    }

    public int popAtStack(int index){
        if(index < 0 || index >= stackList.size() || stackList.get(index).isEmpty()){
            return -1;
        }

        int val = stackList.get(index).pollLast();
        availablePush.add(index);

        // update rightMost
        if(index == rightMost){
            while (rightMost >= 0 && stackList.get(rightMost).isEmpty()){
                rightMost--;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        Ex3_3_StackOfPlate_Optimize D = new Ex3_3_StackOfPlate_Optimize(2);  // Initialize with capacity = 2
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
