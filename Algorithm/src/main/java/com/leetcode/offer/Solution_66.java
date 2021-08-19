package com.leetcode.offer;

public class Solution_66 {
    public int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        ans[0] = 1;
        for (int i = 1, cur = 1; i < a.length; i++) {
            cur *= a[i - 1];
            ans[i] = cur;
        }
        for (int i = a.length - 2, cur = 1; i >= 0; i--) {
            cur *= a[i + 1];
            ans[i] *= cur;
        }
        return ans;
    }
}
