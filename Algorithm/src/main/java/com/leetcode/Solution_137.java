package com.leetcode;

import java.util.Arrays;

public class Solution_137 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i += 3) {
            if (nums[i] != nums[i + 3]) return nums[i];
        }
        return nums[nums.length - 1];
    }
}
