package com.review;

import org.testng.annotations.Test;

public class Solution_96Test {

    @Test
    public void testNumTrees() {
        Solution_96 solution96 = new Solution_96();
        System.out.println(solution96.numTrees(3));
    }

    @Test
    public void testTestNumTrees() {
    }

    @Test
    public void testSolution() {
        Solution_96 solution96 = new Solution_96();
        int[][] ints = new int[1][1];
//        ints[0] = new int[]{1, 1, 1};
//        ints[1] = new int[]{1, 3, 4};
//        ints[2] = new int[]{1, 4, 3};

        ints[0] = new int[]{0};
        System.out.println(solution96.solution(ints));
    }
}