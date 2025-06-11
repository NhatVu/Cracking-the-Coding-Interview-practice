package org.example.chap3StackQueue;

import java.util.Stack;

public class Ex_3_5_Sort_stack {
    /*
    https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
     */

    public Stack<Integer> sort(Stack<Integer> origin) {
        // add code here.
        int n = origin.size();

        Stack<Integer> tmp = new Stack<>();
        while (!origin.isEmpty()) {
            /* Insert each element in s in sorted order into r. */
            int minCandidate = origin.pop();
            while (!tmp.isEmpty() && tmp.peek() > minCandidate) {
                origin.push(tmp.pop());
            }
            tmp.push(minCandidate);
        }

        while (!tmp.isEmpty()) {
            origin.push(tmp.pop());
        }
        return origin;
    }

    /*
    oritinal stack: [34, 3, 31, 98, 92, 23]
    result: [3, 23, 31, 34, 92, 98]
     */
    public static void main(String[] args) {
        Ex_3_5_Sort_stack solution = new Ex_3_5_Sort_stack();
        Stack<Integer> origin = new Stack<>();
        origin.push(34);
        origin.push(3);
        origin.push(31);
        origin.push(98);
        origin.push(92);
        origin.push(23);
        System.out.println("origin: " + origin.toString());

        Stack<Integer> sorted = solution.sort(origin);
        System.out.println("sorted: " + sorted.toString());
        System.out.println();

        /*
        Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2

         */
        origin = new Stack<>();
        origin.push(11);
        origin.push(2);
        origin.push(32);
        origin.push(3);
        origin.push(41);
        System.out.println("origin: " + origin.toString());

        sorted = solution.sort(origin);
        System.out.println("sorted: " + sorted.toString());
        System.out.println();


        origin = new Stack<>();
        origin.push(3);
        origin.push(2);
        origin.push(1);
        System.out.println("origin: " + origin.toString());

        sorted = solution.sort(origin);
        System.out.println("sorted: " + sorted.toString());
        System.out.println();

    }
}
