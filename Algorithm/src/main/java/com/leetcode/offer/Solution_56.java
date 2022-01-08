package com.leetcode.offer;

public class Solution_56 {
    public int[] singleNumbers(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        n = n & -n;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & n) == 0) {
                ans[0] ^= nums[i];
            } else {
                ans[1] ^= nums[i];
            }
        }
        return ans;
    }

    public int singleNumber(int[] nums) {
        int[] ints = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for (int j = 0; j < 32; j++) {
                if (n % 2 != 0) {
                    ints[ints.length - 1 - j]++;
                }
                n = n >>> 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < ints.length; i++) {
            ints[i] %= 3;
            if (ints[i] != 0) {
                ans += 1 << (31 - i);
            }
        }
        return ans;
    }
}
