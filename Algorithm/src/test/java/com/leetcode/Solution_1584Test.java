package com.leetcode;

import org.testng.annotations.Test;

public class Solution_1584Test {

    @Test
    public void testMinCostConnectPoints() {
        int[][] ints = new int[5][];
        ints[0] = new int[]{0, 0};
        ints[1] = new int[]{2, 2};
        ints[2] = new int[]{3, 10};
        ints[3] = new int[]{5, 2};
        ints[4] = new int[]{7, 0};
        Solution_1584 solution_1584 = new Solution_1584();
        System.out.println(solution_1584.minCostConnectPoints(ints));
    }
}