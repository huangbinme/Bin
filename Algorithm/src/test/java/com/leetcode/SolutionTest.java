package com.leetcode;

import org.testng.annotations.Test;

public class SolutionTest {

    @Test
    public void testJump() {
        Solution solution = new Solution();
        int[] ints1 = new int[]{0,2};
        int[] ints2 = new int[]{2,1};
        int[] ints3 = new int[]{3,4};
        int[] ints4 = new int[]{2,3};
        int[] ints5 = new int[]{1,4};
        int[] ints6 = new int[]{2,0};
        int[] ints7 = new int[]{0,4};
        int[][] ints = new int[7][2];
        ints[0] = ints1;
        ints[1] = ints2;
        ints[2] = ints3;
        ints[3] = ints4;
        ints[4] = ints5;
        ints[5] = ints6;
        ints[6] = ints7;
        System.out.println(solution.numWays(5,ints,3));
    }

    @Test
    public void testNumWays() {
    }
}