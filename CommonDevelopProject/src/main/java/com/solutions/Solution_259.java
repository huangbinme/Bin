package com.solutions;

import java.util.Arrays;

public class Solution_259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < target) {
                    ans += (r - l);
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
