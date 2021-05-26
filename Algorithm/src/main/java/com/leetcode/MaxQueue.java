package com.leetcode;

import java.util.LinkedList;

public class MaxQueue {

    LinkedList<Integer> q;
    LinkedList<Integer> d;

    public MaxQueue() {
        q = new LinkedList<>();
        d = new LinkedList<>();
    }

    public int max_value() {
        return d.size() == 0 ? -1 : d.peek();
    }

    public void push_back(int value) {
        q.offerLast(value);
        while (d.size() != 0 && d.peekLast() <= value) {
            d.pollLast();
        }
        d.offerLast(value);
    }

    public int pop_front() {
        if (q.size() == 0) return -1;
        Integer v = q.pollFirst();
        if (d.size() != 0 && d.peek().equals(v)) {
            d.pollFirst();
        }
        return v;
    }
}
