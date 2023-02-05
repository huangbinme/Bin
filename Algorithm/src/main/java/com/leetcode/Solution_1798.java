package com.leetcode;

import java.util.Arrays;

public class Solution_1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int c = 0;
        for (int i = 0; i < coins.length; i++) {
            if(c + 1 < coins[i]) break;
            c += coins[i];
        }
        return c + 1;
    }
}
