package com.leetcode.offer;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_29Test {

    @Test
    public void testSpiralOrder() {
        int[][] ints = new int[4][4];
        ints[0] = new int[]{1,2,3,4};
        ints[1] = new int[]{5,6,7,8};
        ints[2] = new int[]{9,10,11,12};
        ints[3] = new int[]{13,14,15,16};
        Solution_29 solution_29 = new Solution_29();
        System.out.println(Arrays.toString(solution_29.spiralOrder(ints)));
    }
}