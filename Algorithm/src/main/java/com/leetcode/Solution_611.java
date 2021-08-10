package com.leetcode;

import java.util.Arrays;

public class Solution_611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if(nums[l] + nums[r] > nums[i]){
                    ans += (r - l);
                    r--;
                }else {
                    l++;
                }
            }
        }
        return ans;
    }
}
