package com.leetcode;

public class Solution_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && canPlaced(flowerbed, i)) ans++;
        }
        return ans >= n;
    }

    private boolean canPlaced(int[] flowerbed, int i) {
        if (i == 0) {
            if (flowerbed.length > 1 && flowerbed[1] == 1) return false;
            flowerbed[0] = 1;
            return true;
        }
        if (i == flowerbed.length - 1) return flowerbed[flowerbed.length - 2] == 0;
        if (flowerbed[i - 1] == 1 || flowerbed[i + 1] == 1) {
            return false;
        } else {
            flowerbed[i] = 1;
            return true;
        }
    }
}
