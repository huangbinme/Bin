package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_1074Test {

    @Test
    public void testNumSubmatrixSumTarget() {
        int[][] ints = new int[3][3];
        ints[0] = new int[]{0,1,0};
        ints[1] = new int[]{1,1,1};
        ints[2] = new int[]{0,1,0};
        Solution_1074 solution_1074 = new Solution_1074();
        System.out.println(solution_1074.numSubmatrixSumTarget(ints,4));
    }
}