package com.leetcode;

import org.testng.annotations.Test;

public class Solution_39Test {

    @Test
    public void testCombinationSum() {
        int[] ints = new int[]{2,3,6,7};
        Solution_39 solution_39 = new Solution_39();
        solution_39.combinationSum(ints,7);
    }
}