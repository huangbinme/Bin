package com.leetcode;

import org.testng.annotations.Test;

public class Solution_743Test {

    @Test
    public void testNetworkDelayTime() {
        Solution_743 solution743 = new Solution_743();
        int[][] ints = new int[3][];
        ints[0] = new int[]{1, 2, 1};
        ints[1] = new int[]{2, 3, 2};
        ints[2] = new int[]{1, 3, 2};
        System.out.println(solution743.networkDelayTime(ints, 3, 1));
    }
}