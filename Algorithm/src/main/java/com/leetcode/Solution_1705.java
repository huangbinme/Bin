package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int ans = 0, curDay = 0;
        while (!queue.isEmpty() || curDay < apples.length) {
            if (curDay < apples.length && apples[curDay] != 0) {
                queue.offer(new int[]{days[curDay] + curDay, apples[curDay]});
            }
            while (!queue.isEmpty() && (queue.peek()[0] <= curDay || queue.peek()[1] == 0)) queue.poll();
            if (!queue.isEmpty()) {
                ans++;
                queue.peek()[1]--;
            }
            curDay++;
        }
        return ans;
    }
}
