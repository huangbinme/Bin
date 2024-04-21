package com.leetcode;

import org.testng.annotations.Test;

public class Solution_3112Test {

    @Test
    public void testMinimumTime() {
        Solution_3112 solution3112 = new Solution_3112();
        int[][] ints = new int[3][];
        ints[0] = new int[]{0, 1, 2};
        ints[1] = new int[]{1, 2, 1};
        ints[2] = new int[]{0, 2, 4};
        solution3112.minimumTime(3, ints, new int[]{1, 3, 5});
    }
}