package com.leetcode;

import java.util.Arrays;

public class Solution_5801 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] minutes = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            boolean plus = dist[i] % speed[i] != 0;
            minutes[i] = dist[i] / speed[i] + (plus ? 1 : 0);
        }
        Arrays.sort(minutes);
        int ans = 0;
        for (int i = 0; i < minutes.length; i++) {
            if (minutes[i] >= i) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}
