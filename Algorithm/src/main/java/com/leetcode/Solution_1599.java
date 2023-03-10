package com.leetcode;

public class Solution_1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (boardingCost * 4 <= runningCost) return -1;
        int profile = 0, runCount = 0, ans = -1;
        for (int i = 0; i < customers.length - 1; i++) {
            runCount++;
            int curProfile = profile;
            if (customers[i] <= 4) {
                curProfile += boardingCost * customers[i] - runningCost;
            } else {
                curProfile += boardingCost * 4 - runningCost;
                customers[i + 1] += customers[i] - 4;
                customers[i] = 0;
            }
            if (curProfile > 0 && curProfile > profile) ans = runCount;
            profile = curProfile;
        }
        int remain = customers[customers.length - 1];
        int newProfile = profile;
        if (4 * boardingCost - runningCost > 0) {
            newProfile += (remain / 4) * (4 * boardingCost - runningCost);
            runCount += remain / 4;
            if (newProfile > 0 && newProfile > profile) ans = runCount;
            remain %= 4;
        }
        if (remain * boardingCost - runningCost > 0) {
            newProfile += remain * boardingCost - runningCost;
            runCount++;
            if (newProfile > 0 && newProfile > profile) ans = runCount;
        }
        return ans;
    }
}
