package com.solutions;

public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        int a = nums.length;
        int[] dp = new int[a];
        dp[0] = 1;
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i==0) continue;

            int max = -1;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    max = Math.max(max,dp[j]);
                }
            }
            if(max==-1){
                dp[i] = 1;
            }else {
                dp[i] = max+1;
                result = Math.max(result,dp[i]);
            }
        }
        return result;
    }


}
