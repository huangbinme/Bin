package com.review;

public class Solution_416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int target = 0;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            for (int j = dp.length - 1; j >= 0; j--) {//0-1背包倒序遍历，完全背包正序遍历
                if (j == curNum || (j - curNum > 0 && dp[j - curNum] == 1)) {
                    dp[j] = 1;
                }
            }
        }
        return dp[dp.length - 1] == 1;
    }
}
