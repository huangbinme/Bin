package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_329Test {

    @Test
    public void testLongestIncreasingPath() {
        Solution_329 solution329 = new Solution_329();
        int[][] ints = new int[4][4];
        ints[0] = new int[]{13,5,13,9};
        ints[1] = new int[]{5,0,2,9};
        ints[2] = new int[]{10,13,11,10};
        ints[3] = new int[]{0,0,13,13};
        System.out.println(solution329.longestIncreasingPath(ints));
    }
}