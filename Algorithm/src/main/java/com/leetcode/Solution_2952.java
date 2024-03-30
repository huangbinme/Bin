package com.leetcode;

import java.util.Arrays;

public class Solution_2952 {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        long max = 0, ans = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= max + 1) {
                max += coins[i];
            } else {
                while (coins[i] > max + 1) {
                    ans++;
                    max += (max + 1);
                }
                max += coins[i];
            }
        }
        while (max < target) {
            ans++;
            max += (max + 1);
        }
        return (int) ans;
    }
}
