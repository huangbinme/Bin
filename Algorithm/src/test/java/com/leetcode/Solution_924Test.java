package com.leetcode;

import org.testng.annotations.Test;

public class Solution_924Test {

    @Test
    public void testMinMalwareSpread() {
        Solution_924 solution924 = new Solution_924();
        int[][] ints = new int[4][];
        ints[0] = new int[]{1, 0, 0, 0};
        ints[1] = new int[]{0, 1, 0, 0};
        ints[2] = new int[]{0, 0, 1, 1};
        ints[3] = new int[]{0, 0, 1, 1};
        int[] ints1 = new int[]{3, 1};
        System.out.println(solution924.minMalwareSpread(ints, ints1));
        int i = 0;
    }

    @Test
    public void testMinMalwareSpread2() {
        Solution_924 solution924 = new Solution_924();
        int[][] ints = new int[3][];
        ints[0] = new int[]{1, 1, 0};
        ints[1] = new int[]{1, 1, 0};
        ints[2] = new int[]{0, 0, 1};
        int[] ints1 = new int[]{0, 1, 2};
        System.out.println(solution924.minMalwareSpread(ints, ints1));
        int i = 0;
    }

    @Test
    public void testMinMalwareSpread3() {
        Solution_924 solution924 = new Solution_924();
        int[][] ints = new int[11][];
        ints[0] = new int[]{1,0,0,0,1,0,0,0,0,0,1};
        ints[1] = new int[]{0,1,0,1,0,0,0,0,0,0,0};
        ints[2] = new int[]{0,0,1,0,0,0,0,1,0,0,0};
        ints[3] = new int[]{0,1,0,1,0,1,0,0,0,0,0};
        ints[4] = new int[]{1,0,0,0,1,0,0,0,0,0,0};
        ints[5] = new int[]{0,0,0,1,0,1,0,0,1,1,0};
        ints[6] = new int[]{0,0,0,0,0,0,1,1,0,0,0};
        ints[7] = new int[]{0,0,1,0,0,0,1,1,0,0,0};
        ints[8] = new int[]{0,0,0,0,0,1,0,0,1,0,0};
        ints[9] = new int[]{0,0,0,0,0,1,0,0,0,1,0};
        ints[10] = new int[]{1,0,0,0,0,0,0,0,0,0,1};
        int[] ints1 = new int[]{7,8,6,2,3};
        System.out.println(solution924.minMalwareSpread(ints, ints1));
        int i = 0;
    }
}