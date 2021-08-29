package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxStack {

    Deque<Integer> stack;
    Deque<Integer> maxStack;

    public MaxStack() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.offerLast(x);
        if (maxStack.isEmpty() || maxStack.peekLast() <= x) {
            maxStack.offerLast(x);
        }
    }

    public int pop() {
        int pop = stack.pollLast();
        if (maxStack.peekLast().equals(pop)) {
            maxStack.pollLast();
        }
        return pop;
    }

    public int top() {
        return stack.peekLast();
    }

    public int peekMax() {
        return maxStack.peekLast();
    }

//    public int popMax() {
//
//    }
}
