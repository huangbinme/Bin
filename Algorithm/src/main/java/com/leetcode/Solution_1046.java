package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            priorityQueue.offer(stones[i]);
        }
        while (priorityQueue.size() > 1) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            if (a != b) priorityQueue.offer(Math.abs(a - b));
        }
        return priorityQueue.size() == 0 ? 0 : priorityQueue.poll();
    }
}
