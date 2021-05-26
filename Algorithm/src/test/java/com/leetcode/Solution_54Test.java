package com.leetcode;

import junit.framework.TestCase;
import org.testng.annotations.Test;

public class Solution_54Test extends TestCase {

    public void testSpiralOrder() {
        int[][] input = new int[3][3];
        input[0] = new int[]{1,2,3};
        input[1] = new int[]{4,5,6};
        input[2] = new int[]{7,8,9};
        Solution_54 solution_54 = new Solution_54();
        solution_54.spiralOrder(input);
    }

    public void testSpiralOrder1() {
        int[][] input = new int[1][1];
        input[0] = new int[]{1};
        Solution_54 solution_54 = new Solution_54();
        solution_54.spiralOrder(input);
    }

    public void testSpiralOrder2() {
        int[][] input = new int[2][3];
        input[0] = new int[]{1,2};
        input[1] = new int[]{3,4};
        Solution_54 solution_54 = new Solution_54();
        solution_54.spiralOrder(input);
    }

    public void testSpiralOrder3() {
        int[][] input = new int[4][4];
        input[0] = new int[]{1,2,3,4};
        input[1] = new int[]{5,6,7,8};
        input[2] = new int[]{9,10,11,12};
        input[3] = new int[]{13,14,15,16};
        Solution_54 solution_54 = new Solution_54();
        solution_54.spiralOrder(input);
    }

    @Test
    public void testTestSpiralOrder() {
    }
}