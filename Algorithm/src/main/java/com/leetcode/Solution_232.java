package com.leetcode;

import java.util.Stack;

public class Solution_232 {
    Stack<Integer> stackForPush;
    Stack<Integer> stackForPop;

    public Solution_232() {
        stackForPush = new Stack<>();
        stackForPop = new Stack<>();
    }

    /**
     * Push element x to the back of base.queue.
     */
    public void push(int x) {
        popToPush();
        stackForPush.push(x);
    }

    /**
     * Removes the element from in front of base.queue and returns that element.
     */
    public int pop() {
        pushToPop();
        int i = stackForPop.pop();
        popToPush();
        return i;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        pushToPop();
        int i = stackForPop.peek();
        popToPush();
        return i;
    }

    /**
     * Returns whether the base.queue is empty.
     */
    public boolean empty() {
        return stackForPush.empty();
    }

    private void popToPush() {
        int size = stackForPop.size();
        for (int i = 0; i < size; i++) {
            stackForPush.push(stackForPop.pop());
        }
    }

    private void pushToPop() {
        int size = stackForPush.size();
        for (int i = 0; i < size; i++) {
            stackForPop.push(stackForPush.pop());
        }
    }
}
