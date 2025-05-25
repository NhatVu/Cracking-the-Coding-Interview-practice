package org.example.chap3StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/implement-queue-using-stacks/submissions/1644154527/
 */

public class Ex3_4_Queue_via_stacks {

    Deque<Integer> newStack = new ArrayDeque<>();
    Deque<Integer> oldStack = new ArrayDeque<>();

    public Ex3_4_Queue_via_stacks() {

    }

    public void push(int x) {
        newStack.addLast(x);
    }

    public int pop() {
        shiftStack();
        return oldStack.pollLast();
    }

    public int peek() {
        shiftStack();
        return oldStack.peekLast();
    }

    public boolean empty() {
        return oldStack.isEmpty() && newStack.isEmpty();
    }

    private void shiftStack(){
        if(oldStack.isEmpty()){
            while (!newStack.isEmpty()){
                oldStack.addLast(newStack.pollLast());
            }
        }
    }

    public static void main(String[] args) {
        Ex3_4_Queue_via_stacks myQueue = new Ex3_4_Queue_via_stacks();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
