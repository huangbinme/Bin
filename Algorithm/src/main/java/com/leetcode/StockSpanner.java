package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class StockSpanner {
    //[100, 80, 60, 70, 60, 75, 85]

    Deque<int[]> deque;
    int index;

    public StockSpanner() {
        deque = new LinkedList<>();
        index = 0;
    }

    public int next(int price) {
        while (!deque.isEmpty() && deque.peekLast()[0] <= price) {
            deque.pollLast();
        }
        if (!deque.isEmpty()) {
            int ans = index - deque.peekLast()[1];
            deque.offerLast(new int[]{price, index});
            index++;
            return ans;
        } else {
            deque.offerLast(new int[]{price, index});
            index++;
            return ++index;
        }
    }
}
