package com.leetcode;

import java.util.Arrays;

public class Solution_2335 {
    public int fillCups(int[] amount) {
        int ans = 0;
        Arrays.sort(amount);
        while (amount[0] != 0) {
            amount[0]--;
            amount[2]--;
            ans++;
            Arrays.sort(amount);
        }
        while (amount[1] != 0) {
            amount[1]--;
            amount[2]--;
            ans++;
            Arrays.sort(amount);
        }
        ans += amount[2];
        return ans;
    }
}
