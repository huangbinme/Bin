package com.solutions;

import java.util.LinkedList;

public class Solution_862 {
    public int shortestSubarray(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }
        int ans = Integer.MAX_VALUE;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < preSum.length; i++) {
            while (!list.isEmpty() && preSum[list.peekLast()] > preSum[i]) {
                list.pollLast();
            }
            while (!list.isEmpty() && preSum[i] - preSum[list.peekFirst()] >= k) {
                ans = Math.min(ans, i - list.peekFirst());
                list.pollFirst();
            }
            list.offerLast(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
