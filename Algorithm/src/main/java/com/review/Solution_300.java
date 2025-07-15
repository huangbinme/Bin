package com.review;

import java.util.Arrays;

public class Solution_300 {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp,1);
            int ans = 1;
            for (int i = 0; i < nums.length; i++) {
                int sub = 1;
                for (int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]){
                        sub = Math.max(sub, dp[j] + 1);
                    }
                }
                dp[i] = sub;
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
}
