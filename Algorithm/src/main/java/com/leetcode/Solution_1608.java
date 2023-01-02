package com.leetcode;

import java.util.Arrays;

public class Solution_1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            int count = nums.length - i;
            if (nums[i - 1] != nums[i] && count <= nums[i] && count > nums[i - 1]) {
                return count;
            }
        }
        return nums.length <= nums[0] ? nums.length : -1;
    }
}
