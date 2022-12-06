package com.leetcode;

public class Solution_1769 {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        int l = 0, r = 0;
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                ans[0] += i;
                r++;
            }
        }
        for (int i = 1; i < ans.length; i++) {
            int pre = boxes.charAt(i - 1) - '0';
            ans[i] = l - r + pre + ans[i - 1];
            l += pre;
            r -= (boxes.charAt(i) - '0');
        }
        return ans;
    }
}
