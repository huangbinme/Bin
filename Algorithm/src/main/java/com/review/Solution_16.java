package com.review;

import java.util.Arrays;

public class Solution_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int curSum = nums[l] + nums[r] + nums[i];
                if (curSum == target) {
                    return target;
                } else if (curSum > target) {
                    ans = Math.abs(curSum - target) < Math.abs(ans - target) ? curSum : ans;
                    r--;
                } else {
                    ans = Math.abs(curSum - target) < Math.abs(ans - target) ? curSum : ans;
                    l++;
                }
            }
        }
        return ans;
    }
}
