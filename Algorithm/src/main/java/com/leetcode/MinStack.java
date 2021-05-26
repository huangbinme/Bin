package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> deque;
    Deque<Integer> minDeque;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        deque = new LinkedList<>();
        minDeque = new LinkedList<>();
    }

    public void push(int val) {
        deque.offerLast(val);
        if(minDeque.isEmpty()){
            minDeque.offerLast(val);
        }else {
            if (minDeque.peekLast()>=val) {
                minDeque.offerLast(val);
            }
        }
    }

    public void pop() {
        Integer num = deque.pollLast();
        if (num.equals(minDeque.peekLast())) minDeque.pollLast();
    }

    public int top() {
        return deque.peekLast();
    }

    public int getMin() {
        return minDeque.peekLast();
    }
}
