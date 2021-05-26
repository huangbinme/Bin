package com.leetcode;

public class Solution_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans = 0;
        int subAns = 0;
        for (int i = 0; i < customers.length; i++) {
            if (i < X) {
                ans += customers[i];
                continue;
            }
            ans += grumpy[i] == 0 ? customers[i] : 0;
        }
        subAns = ans;
        for (int i = X; i < customers.length; i++) {
            subAns -= grumpy[i - X] == 1 ? customers[i - X] : 0;
            subAns += grumpy[i] == 1 ? customers[i] : 0;
            ans = Math.max(subAns, ans);
        }
        return ans;
    }
}
