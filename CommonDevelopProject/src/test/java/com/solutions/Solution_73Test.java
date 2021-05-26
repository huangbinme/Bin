package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_73Test {

    @Test
    public void testSetZeroes() {
        int[][] ints = new int[3][3];
        ints[0] = new int[]{1,1,1};
        ints[1] = new int[]{1,0,1};
        ints[2] = new int[]{1,1,1};
        Solution_73 solution_73 = new Solution_73();
        solution_73.setZeroes(ints);
        int i = 0;
    }
}