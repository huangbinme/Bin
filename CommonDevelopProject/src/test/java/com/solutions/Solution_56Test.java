package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_56Test {

    @Test
    public void testMerge() {
        int[][] ints = new int[2][2];
        ints[0][0] = 1;
        ints[0][1] = 4;

        ints[1][0] = 0;
        ints[1][1] = 4;
        Solution_56 solution_56 = new Solution_56();
        solution_56.merge(ints);
    }
}