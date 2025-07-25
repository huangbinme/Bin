package com.interview.amazon;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static int maxCredits1(List<Integer> inventory, int dispatch1, int dispatch2, int skips) {
        int[] cost = new int[dispatch1 + dispatch2 + 1];
        cost[0] = dispatch1 >= dispatch2 ? 1 : (dispatch2 / dispatch1) + (dispatch2 % dispatch1);
        for (int i = dispatch1 + 1; i < cost.length; i++) {
            cost[i] = i % dispatch1 == 0 ? (i / dispatch1) - 1 : i / dispatch1;
        }
        int ans = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < inventory.size(); i++) {
            int mod = inventory.get(i) % (dispatch1 + dispatch2);
            int curCost = cost[mod];
            if (curCost == 0) {
                ans++;
            } else {
                priorityQueue.offer(curCost);
            }
        }
        while (priorityQueue.size() != 0 && priorityQueue.peek() <= skips) {
            ans++;
            Integer pollCost = priorityQueue.poll();
            skips -= pollCost;
        }
        return ans;
    }

    public static int maxCredits(List<Integer> inventory, int dispatch1, int dispatch2, int skips) {
        int n = inventory.size();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < n; i++) {
            int cost;
            int r = inventory.get(i);
            r = r % (dispatch1 + dispatch2) == 0 ? dispatch1 + dispatch2 : r % (dispatch1 + dispatch2);
            cost = r <= dispatch1 ? 0 : (r / dispatch1 - (r % dispatch1 == 0 ? 1 : 0));
            queue.add(cost);
        }
        int res = 0;
        while (!queue.isEmpty() && skips >= queue.peek()) {
            skips -= queue.poll();
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1000000000 * 2);
    }

}
