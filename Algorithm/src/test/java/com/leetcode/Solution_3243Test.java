package com.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_3243Test {

    @Test
    public void testShortestDistanceAfterQueries() {
        Solution_3243 solution3243 = new Solution_3243();
        int[][] ints = new int[2][2];
        ints[0] = new int[]{0, 2};
        ints[1] = new int[]{0, 4};
        int[] ints1 = solution3243.shortestDistanceAfterQueries(5, ints);
        System.out.println(Arrays.toString(ints1));
    }
}