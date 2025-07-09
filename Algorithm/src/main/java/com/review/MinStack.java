package com.review;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> min = new LinkedList<>();

    Deque<Integer> deque = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        deque.offerFirst(val);
        if (min.size() == 0 || val <= min.peekFirst()) {
            min.offerFirst(val);
        }
    }

    public void pop() {
        Integer poll = deque.pollFirst();
        if (poll.equals(min.peekFirst())) min.pollFirst();
    }

    public int top() {
        return deque.peekFirst();
    }

    public int getMin() {
        return min.peekFirst();
    }
}
