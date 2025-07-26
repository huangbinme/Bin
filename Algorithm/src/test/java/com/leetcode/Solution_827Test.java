package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_827Test {

    @Test
    public void testLargestIsland() {
        Solution_827 solution827 = new Solution_827();
        int[][] ints = new int[2][2];
        ints[0] = new int[]{1, 1};
        ints[1] = new int[]{0, 1};
        System.out.println(solution827.largestIsland(ints));
    }
}