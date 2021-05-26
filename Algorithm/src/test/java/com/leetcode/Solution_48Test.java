package com.leetcode;

import org.testng.annotations.Test;

public class Solution_48Test {

    @Test
    public void testRotate() {
        int[][] ints = new int[3][3];
        ints[0] = new int[]{1,2,3};
        ints[1] = new int[]{4,5,6};
        ints[2] = new int[]{7,8,9};
        Solution_48 solution_48 = new Solution_48();
        solution_48.rotate(ints);
    }
}