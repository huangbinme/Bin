package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_24Test {

    @Test
    public void testSearchMatrix() {
        Solution_24 solution_24 = new Solution_24();
        int[][] ints = new int[5][5];
        ints[0] = new int[]{1,4,7,11,15};
        ints[1] = new int[]{2,5,8,12,19};
        ints[2] = new int[]{3,6,9,16,22};
        ints[3] = new int[]{10,13,14,17,24};
        ints[4] = new int[]{18,21,23,26,30};
        System.out.println(solution_24.searchMatrix(ints,16));
    }
}