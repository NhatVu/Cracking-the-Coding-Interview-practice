package org.example.chap3StackQueue;

public class Ex3_2_MinStack {
    int[] values;
    int topIndex = -1;
    int stackSize = 0;
    int[] minValues;

    public Ex3_2_MinStack(int stackSize){
        this.stackSize = stackSize;
        values = new int[stackSize];
        minValues = new int[stackSize];
    }
// 9 9 8 10
// 9 9 8 8
    public void push(int value){
        if(isFull()){
            throw new StackException("Stack is full");
        }
        topIndex++;
        values[topIndex] = value;
        if(topIndex == 0){
            minValues[topIndex] = value;
        }else {
            minValues[topIndex] = Math.min(minValues[topIndex - 1], value);
        }
    }

    public int pop(){
        if(isEmpty()){
            throw new StackException("Stack is empty");
        }

        int res = values[topIndex];
        minValues[topIndex] = -1;
        values[topIndex] = -1;
        topIndex--;
        return res;
    }

    public int top(){
        if(isEmpty()){
            throw new StackException("Stack is empty");
        }
        return values[topIndex];
    }

    public int min(){
        if(isEmpty()){
            throw new StackException("Stack is empty");
        }
        return minValues[topIndex];
    }

    public boolean isFull(){
        return topIndex + 1  == stackSize;
    }

    public boolean isEmpty(){
        return topIndex == -1;
    }


    public static void main(String[] args) {
        Ex3_2_MinStack stacks = new Ex3_2_MinStack(4); // each stack can hold 3 items

        // Push values into each stack
        stacks.push(2147483646);
        stacks.push(2147483646);
        stacks.push(2147483647);

        stacks.top();
        stacks.pop();

        System.out.println("getMin: " + stacks.min());

        stacks.pop();
        System.out.println("getMin: " + stacks.min());

        stacks.pop();
        stacks.push(2147483647);

        stacks.top();
        System.out.println("getMin: " + stacks.min());

        stacks.push(-2147483647);

        stacks.top();
        System.out.println("getMin: " + stacks.min());

        stacks.pop();
        System.out.println("getMin: " + stacks.min());


    }

}
