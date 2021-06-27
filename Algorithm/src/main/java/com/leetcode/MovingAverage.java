package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {
    Deque<Integer> deque;
    Integer sum;
    Integer maxSize;

    public MovingAverage(int size) {
        deque = new LinkedList<>();
        sum = 0;
        maxSize = size;
    }

    public double next(int val) {
        if (deque.size() == maxSize) {
            sum -= deque.pollFirst();
            deque.offerLast(val);
        } else {
            deque.offerLast(val);
        }
        sum += val;
        return (double) sum / deque.size();
    }
}
