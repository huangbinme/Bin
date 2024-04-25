package com.leetcode;

public class Solution_2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0, add = 0;
        while (mainTank != 0) {
            mainTank--;
            add++;
            if (add == 5 && additionalTank > 0) {
                add = 0;
                mainTank++;
                additionalTank--;
            }
            ans += 10;
        }
        return ans;
    }
}
