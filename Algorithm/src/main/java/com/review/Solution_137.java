package com.review;

public class Solution_137 {
    public int singleNumber(int[] nums) {
        int[] stat = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i], statIndex = 0;
            while (n != 0) {
                stat[statIndex++] += (n % 2 == 0 ? 0 : 1);
                n >>>= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < stat.length; i++) {
            ans += (stat[i] % 3 == 0 ? 0 : 1 << i);
        }
        return ans;
    }
}