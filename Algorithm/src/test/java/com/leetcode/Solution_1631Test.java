package com.leetcode;

import org.testng.annotations.Test;

public class Solution_1631Test {

    @Test
    public void testMinimumEffortPath() {
        Solution_1631 solution1631 = new Solution_1631();
        int[][] ints = new int[5][];
        ints[0] = new int[]{1,2,1,1,1};
        ints[1] = new int[]{1,2,1,2,1};
        ints[2] = new int[]{1,2,1,2,1};
        ints[3] = new int[]{1,2,1,2,1};
        ints[4] = new int[]{1,1,1,2,1};
        System.out.println(solution1631.minimumEffortPath(ints));
    }
}