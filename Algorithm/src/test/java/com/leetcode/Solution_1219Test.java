package com.leetcode;

import org.testng.annotations.Test;

public class Solution_1219Test {

    @Test
    public void testGetMaximumGold() {
        Solution_1219 solution1219 = new Solution_1219();
        int[][] ints = new int[3][];
        ints[0] = new int[]{0, 6, 0};
        ints[1] = new int[]{5, 8, 7};
        ints[2] = new int[]{0, 9, 0};
        System.out.println(solution1219.getMaximumGold(ints));
    }
}