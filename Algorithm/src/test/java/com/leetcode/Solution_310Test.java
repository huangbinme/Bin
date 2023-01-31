package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_310Test {

    @Test
    public void testFindMinHeightTrees() {
        Solution_310 solution310 = new Solution_310();
        int[][] ints = new int[6][];
        ints[0] = new int[]{0, 1};
        ints[1] = new int[]{1, 2};
        ints[2] = new int[]{1, 3};
        ints[3] = new int[]{2, 4};
        ints[4] = new int[]{3, 5};
        ints[5] = new int[]{4, 6};
        System.out.println(solution310.findMinHeightTrees(7, ints));
    }
}