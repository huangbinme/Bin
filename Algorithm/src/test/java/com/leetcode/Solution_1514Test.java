package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_1514Test {

    @Test
    public void testMaxProbability() {
        int[][] edges = new int[6][];
        edges[0] = new int[]{1, 4};
        edges[1] = new int[]{2, 4};
        edges[2] = new int[]{0, 4};
        edges[3] = new int[]{0, 3};
        edges[4] = new int[]{0, 2};
        edges[5] = new int[]{2, 3};
        Solution_1514 solution1514 = new Solution_1514();
        System.out.println(solution1514.maxProbability(5, edges, new double[]{0.37,0.17,0.93,0.23,0.39,0.04}, 3, 4));
    }
}