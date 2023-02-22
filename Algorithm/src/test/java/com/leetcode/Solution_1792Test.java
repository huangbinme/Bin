package com.leetcode;

import org.testng.annotations.Test;

public class Solution_1792Test {

    @Test
    public void testMaxAverageRatio() {
        int[][] ints = new int[3][];
        ints[0] = new int[]{1, 2};
        ints[1] = new int[]{3, 5};
        ints[2] = new int[]{2, 2};
        Solution_1792 solution1792 = new Solution_1792();
        System.out.println(solution1792.maxAverageRatio(ints, 2));
    }
}