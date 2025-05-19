package org.example.chap3StackQueue;

public class Ex3_1_FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes; // record curr sizes of each stack

    public Ex3_1_FixedMultiStack(int stackCapacity){
        this.stackCapacity = stackCapacity;
        this.values = new int[stackCapacity * numberOfStacks];
        this.sizes = new int[stackCapacity];
    }

    /* Push value onto stack. */
    public void push(int stackNum, int value) throws StackException {
        if(isFull(stackNum))
            throw new StackException("Full stack exception");
        sizes[stackNum] = sizes[stackNum] + 1;
        int index = indexOfTop(stackNum);
        values[index] = value;
    }

    /* Pop item from top stack. */
    public int pop(int stackNum) {
        if(isEmpty(stackNum))
            throw new StackException("Full stack exception");
        int res = values[indexOfTop(stackNum)];
        values[indexOfTop(stackNum)] = -1; // clean data
        sizes[stackNum] = sizes[stackNum] - 1;
        return res;
    }

    /* Return top element. */
    public int peek(int stackNum) {
        if(isEmpty(stackNum))
            throw new StackException("Empty stack exception");
        return values[indexOfTop(stackNum)];
    }

    /* Return if stack is empty. */
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    /* Return if stack is full. */
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    /* Returns index of the top of the stack. */
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        return offset + sizes[stackNum] - 1;
    }

    public static void main(String[] args) {
        Ex3_1_FixedMultiStack stacks = new Ex3_1_FixedMultiStack(3); // each stack can hold 3 items

        // Push values into each stack
        stacks.push(0, 10);
        stacks.push(0, 11);
        stacks.push(1, 20);
        stacks.push(2, 30);
        stacks.push(2, 31);
        stacks.push(2, 32);

        System.out.println("Top of Stack 0: " + stacks.peek(0)); // 11
        System.out.println("Top of Stack 1: " + stacks.peek(1)); // 20
        System.out.println("Top of Stack 2: " + stacks.peek(2)); // 32

        System.out.println("Popped from Stack 2: " + stacks.pop(2)); // 32
        System.out.println("New Top of Stack 2: " + stacks.peek(2)); // 31

        // Try to push into full stack
        try {
            stacks.push(2, 33); // should work
            stacks.push(2, 34); // should throw error
        } catch (StackException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // Try to pop from empty stack
        try {
            stacks.pop(1); // pops 20
            stacks.pop(1); // should throw error
        } catch (RuntimeException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
