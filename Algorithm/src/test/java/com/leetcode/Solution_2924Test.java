package com.leetcode;

import junit.framework.TestCase;

public class Solution_2924Test extends TestCase {

    public void testFindChampion() {
        Solution_2924 solution2924 = new Solution_2924();
        int[][] ints = new int[2][];
        ints[0] = new int[]{0, 1};
        ints[1] = new int[]{1, 2};
        solution2924.findChampion(3, ints);
    }
}