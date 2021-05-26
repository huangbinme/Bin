package com.leetcode;

import org.testng.annotations.Test;

public class Solution_57Test {

    @Test
    public void testInsert() {
        Solution_57 solution_57 = new Solution_57();
        int[][] ints = new int[1][2];
        ints[0] = new int[]{1,5};
        solution_57.insert(ints,new int[]{2,3});
    }
}