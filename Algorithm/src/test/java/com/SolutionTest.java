package com;

import org.testng.annotations.Test;

public class SolutionTest {

    @Test
    public void testSolution() {

    }

    @Test
    public void testMinLength() {

    }

    @Test
    public void testTestSolution() {

    }

    @Test
    public void testGetMaxPages() {
        Solution s = new Solution();
        int[] ints = new int[]{2, 6, 10, 13};
        int[] ints2 = new int[]{2, 1, 1, 1};
    }

    @Test
    public void testNumOfSubsequences() {

    }

    @Test
    public void testTestNumOfSubsequences() {
        //LCLTT
        //LCLTT -> 5
        com.Solution solution = new com.Solution();
        //System.out.println(solution.numOfSubsequences("LCTKLCLT"));//7


        //LCL(C)TTC
        System.out.println(solution.numOfSubsequences("LCLPTTGC"));//6
    }

    @Test
    public void testCheckDivisibility() {
        com.Solution solution = new com.Solution();
        solution.checkDivisibility(99);
    }

    @Test
    public void testCountTrapezoids2() {
        com.Solution solution = new com.Solution();
        int[][] ints = new int[4][2];
        //[-3,2],[3,0],[2,3],[3,2],[2,-3]©leetcode
        //ints[0] = new int[]{-3, 2};
        ints[0] = new int[]{3, 0};
        ints[1] = new int[]{2, 3};
        ints[2] = new int[]{3, 2};
        ints[3] = new int[]{2, -3};
        System.out.println(solution.countTrapezoids2(ints));
    }

    @Test
    public void testMaximumProfit() {
        Solution solution = new Solution();
        //System.out.println(solution.maximumProfit(new int[]{12,16,19,19,8,1,19,13,9}, 3));
    }
}