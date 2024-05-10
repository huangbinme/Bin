package com.leetcode;

public class Solution_2960 {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] - ans > 0) {
                ans++;
            }
        }
        return ans;
    }
}
