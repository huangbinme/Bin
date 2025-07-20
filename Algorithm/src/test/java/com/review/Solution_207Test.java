package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_207Test {

    @Test
    public void testCanFinish() {
        Solution_207 solution207 = new Solution_207();
        int[][] ints = new int[4][2];
        ints[0] = new int[]{1, 4};
        ints[1] = new int[]{2, 4};
        ints[2] = new int[]{3, 1};
        ints[3] = new int[]{3, 2};
        solution207.canFinish(5, ints);
    }

    @Test
    public void testCanFinish2() {
        Solution_207 solution207 = new Solution_207();
        int[][] ints = new int[2][2];
        ints[0] = new int[]{1, 0};
        ints[1] = new int[]{0, 1};
        solution207.canFinish(2, ints);
    }
}