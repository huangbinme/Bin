package com.leetcode;

import org.testng.annotations.Test;

public class Solution_994Test {

    @Test
    public void testOrangesRotting() {
        Solution_994 solution994 = new Solution_994();
        int[][] ints = new int[3][];
        ints[0] = new int[]{2, 1, 1};
        ints[1] = new int[]{1, 1, 0};
        ints[2] = new int[]{0, 1, 1};
        solution994.orangesRotting(ints);
    }
}