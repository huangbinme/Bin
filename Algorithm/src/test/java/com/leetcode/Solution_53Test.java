package com.leetcode;

import org.testng.annotations.Test;

public class Solution_53Test {

    @Test
    public void testMaxSubArray() {
        Solution_53 solution_53 = new Solution_53();
        int[] ints = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        solution_53.maxSubArray(ints);
    }

    @Test
    public void testTestMaxSubArray() {
    }
}