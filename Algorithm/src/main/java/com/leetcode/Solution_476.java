package com.leetcode;

public class Solution_476 {
    public int findComplement(int num) {
        int max = 0, cp = num;
        for (int i = 0; i < 31; i++) {
            cp = cp >> 1;
            max++;
            if (cp == 0) break;
        }
        int ans = 0;
        for (int i = 0; i < max; i++) {
            if ((num >> i) % 2 == 0) {
                ans = ans | (1 << i);
            }
        }
        return ans;
    }
}
