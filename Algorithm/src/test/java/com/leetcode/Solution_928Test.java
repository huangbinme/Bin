package com.leetcode;

import org.testng.annotations.Test;

public class Solution_928Test {

    @Test
    public void testMinMalwareSpread() {
        Solution_928 solution924 = new Solution_928();
        int[][] ints = new int[4][];
        ints[0] = new int[]{1, 1, 0, 0};
        ints[1] = new int[]{1, 1, 1, 0};
        ints[2] = new int[]{0, 1, 1, 1};
        ints[3] = new int[]{0, 0, 1, 1};
        int[] ints1 = new int[]{0, 1};
        System.out.println(solution924.minMalwareSpread(ints, ints1));
    }

    @Test
    public void testMinMalwareSpread2() {
        Solution_928 solution924 = new Solution_928();
        int[][] ints = new int[9][];
        ints[0] = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0};
        ints[1] = new int[]{0, 1, 0, 0, 0, 0, 0, 0, 1};
        ints[2] = new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0};
        ints[3] = new int[]{0, 0, 0, 1, 0, 0, 0, 0, 1};
        ints[4] = new int[]{0, 0, 0, 0, 1, 0, 1, 1, 1};
        ints[5] = new int[]{0, 0, 0, 0, 0, 1, 0, 0, 1};
        ints[6] = new int[]{0, 0, 0, 0, 1, 0, 1, 1, 0};
        ints[7] = new int[]{0, 0, 0, 0, 1, 0, 1, 1, 0};
        ints[8] = new int[]{0, 1, 0, 1, 1, 1, 0, 0, 1};
        int[] ints1 = new int[]{8, 4, 2, 0};
        System.out.println(solution924.minMalwareSpread(ints, ints1));
    }
}