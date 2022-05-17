package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_812 {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    ans = Math.max(ans, getArea(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    private double getArea(int[] ints1, int[] ints2, int[] ints3) {
        return Math.abs((ints1[0] * (ints2[1] - ints3[1]) + ints2[0] * (ints3[1] - ints1[1]) + ints3[0] * (ints1[1] - ints2[1])) * 0.5);
    }

    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int ans = 0;
        for (int i = 0; i <= numStr.length() - k; i++) {
            String sub = numStr.substring(i, i + k);
            int n = Integer.parseInt(sub);
            if (n != 0 && num % n == 0) ans++;
        }
        return ans;
    }

    public int waysToSplitArray(int[] nums) {
        long[] dp = new long[nums.length + 1];
        long sum = 0;
        for (int i = 1; i < dp.length; i++) {
            sum += nums[i - 1];
            dp[i] = sum;
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            long l = dp[i + 1];
            long r = dp[dp.length - 1] - dp[i + 1];
            if (l >= r) ans++;
        }
        return ans;
    }

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        int l = 0, r = 0, ans = 0, win = 0;
        while (r < tiles.length) {
            if (tiles[r][1] - tiles[l][0] + 1 <= carpetLen) {
                win += tiles[r][1] - tiles[r][0] + 1;
                ans = Math.max(ans, win);
                r++;
            } else {
                int bound = carpetLen + tiles[l][0] - tiles[r][0];
                ans = Math.max(ans, win + bound);
                win -= tiles[l][1] - tiles[l][0] + 1;
                l++;
            }
        }
        return ans;
    }
}
