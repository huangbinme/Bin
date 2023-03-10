package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_2373 {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = 0; k <= 2; k++) {
                    for (int l = 0; l <= 2; l++) {
                        max = Math.max(max, grid[i + k][j + l]);
                    }
                }
                ans[i][j] = max;
            }
        }
        return ans;
    }

    public int minMaxDifference(int num) {
        String max = String.valueOf(num);
        for (int i = 0; i < max.length(); i++) {
            if (max.charAt(i) != '9') {
                max = max.replace(max.charAt(i), '9');
                break;
            }
        }
        String min = String.valueOf(num);
        min = min.replace(min.charAt(0), '0');
        return Integer.parseInt(max) - Integer.parseInt(min);
    }

    public int minImpossibleOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int ans = 1;
        while (set.contains(ans)){
            ans <<= 1;
        }
        return ans;
    }
}
