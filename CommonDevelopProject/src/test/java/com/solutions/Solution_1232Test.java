package com.solutions;

import junit.framework.TestCase;

public class Solution_1232Test extends TestCase {

    public void testCheckStraightLine() {
        Solution_1232 solution_1232 = new Solution_1232();
        int[][] ints = new int[6][2];
        ints[0] = new int[]{1,2};
        ints[1] = new int[]{2,3};
        ints[2] = new int[]{3,4};
        ints[3] = new int[]{5,6};
        ints[4] = new int[]{6,7};
        ints[5] = new int[]{7,8};
        solution_1232.checkStraightLine(ints);
    }
}