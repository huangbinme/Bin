package com.leetcode;

import org.testng.annotations.Test;

public class Solution_1847Test {

    @Test
    public void testClosestRoom() {
        Solution_1847 solution_1847 = new Solution_1847();
        int[][] ints1 = new int[5][2];
        ints1[0] = new int[]{1, 4};
        ints1[1] = new int[]{2, 3};
        ints1[2] = new int[]{3, 5};
        ints1[3] = new int[]{4, 1};
        ints1[4] = new int[]{5, 2};
        int[][] ints2 = new int[3][2];
        ints2[0] = new int[]{2, 3};
        ints2[1] = new int[]{2, 4};
        ints2[2] = new int[]{2, 5};
        solution_1847.closestRoom(ints1, ints2);
    }
}