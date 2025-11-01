package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> q1;
    PriorityQueue<Integer> q2;

    public MedianFinder() {
        q1 = new PriorityQueue<>(Comparator.reverseOrder());
        q2 = new PriorityQueue<>(Comparator.naturalOrder());
    }

    public void addNum(int num) {
        if (q1.size() == q2.size()) {
            q2.offer(num);
            q1.offer(q2.poll());
        } else {
            q1.offer(num);
            q2.offer(q1.poll());
        }
    }

    public double findMedian() {
        if (q1.size() == q2.size()) {
            return (q1.peek() + q2.peek()) / 2.0;
        } else {
            return (double) q1.peek();
        }
    }
}
