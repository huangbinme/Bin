package com.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

public class MaxQueue {
    Deque<Integer> monoDeque;
    Deque<Integer> deque;

    public MaxQueue() {
        monoDeque = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return monoDeque.isEmpty() ? -1 : monoDeque.peekFirst();
    }

    public void push_back(int value) {
        deque.offerLast(value);
        while (!monoDeque.isEmpty() && monoDeque.peekLast() < value){
            monoDeque.pollLast();
        }
        monoDeque.offerLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) return -1;
        int pop = deque.pollFirst();
        if (monoDeque.peekFirst() == pop) monoDeque.pollFirst();
        return pop;
    }
}
