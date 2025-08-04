package com.interview.paypay;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_3 {
    public int findMinimumPrice(int[] price, int m) {
        // write your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < price.length; i++) {
            queue.offer(price[i]);
        }
        while (m > 0) {
            int p = queue.poll();
            if (p == 1) break;
            queue.offer(p / 2);
            m--;
        }
        int ans = 0;
        while (!queue.isEmpty()) ans += queue.poll();
        return ans;
    }
}
