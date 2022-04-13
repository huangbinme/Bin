package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < aliceSizes.length; i++) sumA += aliceSizes[i];
        for (int i = 0; i < bobSizes.length; i++) {
            sumB += bobSizes[i];
            set.add(bobSizes[i]);
        }
        int target = (sumA - sumB) / 2;
        int[] ans = new int[2];
        for (int i = 0; i < aliceSizes.length; i++) {
            if (set.contains(aliceSizes[i] - target)) {
                ans[0] = aliceSizes[i];
                ans[0] = aliceSizes[i] - target;
                break;
            }
        }
        return ans;
    }
}
