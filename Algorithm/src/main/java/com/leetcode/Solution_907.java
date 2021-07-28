package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_907 {
    long ans = 0;
    final long mod = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        Deque<int[]> deque = new LinkedList<>();
        deque.offerLast(new int[]{0, 0});
        for (int i = 0; i < arr.length; i++) {
            inQueue(deque, arr[i], i + 1);
        }
        inQueue(deque, 0, arr.length + 1);
        return (int) ans;
    }

    private void inQueue(Deque<int[]> deque, int num, int index) {
        while (!deque.isEmpty() && deque.peekLast()[0] >= num) {
            int[] out = deque.pollLast();
            if(!deque.isEmpty()){
                int left = out[1] - deque.peekLast()[1];
                int right = index - out[1];
                ans += (long) out[0] * (left * right);
                ans %= mod;
            }
        }
        deque.offerLast(new int[]{num, index});
    }
}
