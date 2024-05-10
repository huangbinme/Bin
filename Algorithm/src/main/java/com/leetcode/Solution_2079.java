package com.leetcode;

public class Solution_2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int curCapacity = capacity - plants[0], ans = 1;
        for (int i = 1; i < plants.length; i++) {
            if (curCapacity >= plants[i]) {
                curCapacity -= plants[i];
                ans += 1;
            } else {
                curCapacity = capacity - plants[i];
                ans += (i * 2 + 1);
            }
        }
        return ans;
    }
}
