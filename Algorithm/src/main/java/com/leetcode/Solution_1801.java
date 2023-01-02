package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] * -1)), sellQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < orders.length; i++) {
            int[] order = orders[i];
            PriorityQueue<int[]> processQueue = order[2] == 0 ? sellQueue : buyQueue;
            PriorityQueue<int[]> waitQueue = order[2] == 0 ? buyQueue : sellQueue;
            processOrder(processQueue, waitQueue, order);
        }
        int ans = 0, guard = 1000000007;
        while (!buyQueue.isEmpty()) {
            ans += buyQueue.poll()[1];
            ans %= guard;
        }
        while (!sellQueue.isEmpty()) {
            ans += sellQueue.poll()[1];
            ans %= guard;
        }
        return ans;
    }

    private void processOrder(PriorityQueue<int[]> processQueue, PriorityQueue<int[]> waitQueue, int[] order) {
        while (order[1] != 0 && !processQueue.isEmpty() && (order[2] == 0 ? processQueue.peek()[0] <= order[0] : processQueue.peek()[0] >= order[0])) {
            if (processQueue.peek()[1] == order[1]) {
                processQueue.poll();
                order[1] = 0;
            } else if (processQueue.peek()[1] > order[1]) {
                processQueue.peek()[1] -= order[1];
                order[1] = 0;
            } else {
                int[] inQueue = processQueue.poll();
                order[1] -= inQueue[1];
            }
        }
        if (order[1] != 0) {
            waitQueue.offer(order);
        }
    }
}
