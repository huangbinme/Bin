package com.leetcode;

public class Solution_1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] pre = new int[arr.length + 1];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            pre[i + 1] = sum;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int length = 0;
            while (i + length < arr.length) {
                ans += (pre[i + length + 1] - pre[i]);
                length += 2;
            }
        }
        return ans;
    }
}
