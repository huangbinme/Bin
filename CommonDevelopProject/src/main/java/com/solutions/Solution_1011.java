package com.solutions;

public class Solution_1011 {
    public int shipWithinDays(int[] weights, int D) {
        int minPower = weights[0];
        int maxPower = 0;
        for (int i = 0; i < weights.length; i++) {
            minPower = Math.max(minPower, weights[i]);
            maxPower += weights[i];
        }
        while (minPower + 1 < maxPower) {
            int midPower = getMid(minPower, maxPower);
            int midPowerDays = getDaysWithPower(weights, midPower);
            if (D < midPowerDays) minPower = midPower;
            if (D >= midPowerDays) maxPower = midPower;
        }
        int minPowerDays = getDaysWithPower(weights, minPower);
        return minPowerDays <= D ? minPower : maxPower;
    }

    public int getDaysWithPower(int[] weights, int power) {
        int days = 1, sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] > power) {
                days++;
                sum = weights[i];
                continue;
            }
            sum += weights[i];
        }
        return days;
    }

    private int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
