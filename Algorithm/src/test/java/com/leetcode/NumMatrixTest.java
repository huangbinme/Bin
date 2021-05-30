package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumMatrixTest {

    @Test
    public void testSumRegion() {
        int[][] ints = new int[5][5];
        ints[0] = new int[]{3, 0, 1, 4, 2};
        ints[1] = new int[]{5, 6, 3, 2, 1};
        ints[2] = new int[]{1, 2, 0, 1, 5};
        ints[3] = new int[]{4, 1, 0, 1, 7};
        ints[4] = new int[]{1, 0, 3, 0, 5};
        NumMatrix numMatrix = new NumMatrix(ints);
        System.out.println(numMatrix.sumRegion(2,1,4,3));
    }
}