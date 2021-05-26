package com.leetcode;

import java.util.Arrays;

public class Solution_217 {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }
}
