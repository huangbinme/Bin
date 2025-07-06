package com.review;

public class Solution_137 {
    public int singleNumber(int[] nums) {
        int[] stat = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i], statIndex = stat.length - 1;
            while (n != 0) {
                stat[statIndex--] += (n % 2);
                n >>>= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < stat.length; i++) {
            if (stat[i] % 3 != 0) {
                ans += (1 << (31 - i));
            }
        }
        return ans;
    }
}