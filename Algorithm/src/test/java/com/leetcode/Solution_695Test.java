package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_695Test {

    @Test
    public void testMaxAreaOfIsland() {
        Solution_695 solution_695 = new Solution_695();
        int[][] ints = new int[8][13];
        ints[0] = new int[]{0,0,1,0,0,0,0,1,0,0,0,0,0};
        ints[1] = new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0};
        ints[2] = new int[]{0,1,1,0,1,0,0,0,0,0,0,0,0};
        ints[3] = new int[]{0,1,0,0,1,1,0,0,1,0,1,0,0};
        ints[4] = new int[]{0,1,0,0,1,1,0,0,1,1,1,0,0};
        ints[5] = new int[]{0,0,0,0,0,0,0,0,0,0,1,0,0};
        ints[6] = new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0};
        ints[7] = new int[]{0,0,0,0,0,0,0,1,1,0,0,0,0};
        System.out.println(solution_695.maxAreaOfIsland(ints));
    }
}