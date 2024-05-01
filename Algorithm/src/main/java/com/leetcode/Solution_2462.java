package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int l = candidates, r = costs.length - 1 - candidates;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.<int[]>comparingInt(v -> v[0]).thenComparing(v -> v[1]));
        initQueue(queue, costs, l, r);
        long ans = 0;
        for (int i = 0; i < k; i++) {
            if (l > r) {
                ans += queue.poll()[0];
            } else {
                int[] fromQueue = queue.poll();
                if (fromQueue[2] == -1) {
                    queue.offer(new int[]{costs[l], l, -1});
                    l++;
                } else {
                    queue.offer(new int[]{costs[r], r, 1});
                    r--;
                }
                ans += fromQueue[0];
            }
        }
        return ans;
    }

    private void initQueue(PriorityQueue<int[]> queue, int[] costs, int l, int r) {
        if (l > r) {
            for (int i = 0; i < costs.length; i++) {
                queue.offer(new int[]{costs[i], i, 0});
            }
        } else {
            int i = 0, j = costs.length - 1;
            while (i < l) {
                queue.offer(new int[]{costs[i], i, -1});
                queue.offer(new int[]{costs[j], j, 1});
                i++;
                j--;
            }
        }
    }
}
