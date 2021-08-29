package com.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.offerLast(x);
        if (minStack.isEmpty() || minStack.peekLast() >= x) {
            minStack.offerLast(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int last = stack.pollLast();
        if (minStack.peekLast().equals(last)) {
            minStack.pollLast();
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int min() {
        return minStack.peekLast();
    }
}
