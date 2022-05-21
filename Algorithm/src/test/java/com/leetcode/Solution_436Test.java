package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_436Test {

    @Test
    public void testFindRightInterval() {
        Solution_436 solution_436 = new Solution_436();
        int[][] ints = new int[3][2];
        ints[0] = new int[]{3,4};
        ints[1] = new int[]{2,3};
        ints[2] = new int[]{1,2};
        solution_436.findRightInterval(ints);
    }
}