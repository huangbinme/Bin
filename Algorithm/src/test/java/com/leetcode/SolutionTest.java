package com.leetcode;

import org.testng.annotations.Test;

public class SolutionTest {

    @Test
    public void testCheckZeroOnes() {
        Solution solution = new Solution();
        int[] ints = new int[]{31, 96, 73, 90, 15, 11, 1, 90, 72, 9, 30, 88};
        int[] ints1 = new int[]{87, 10, 3, 5, 76, 74, 38, 64, 16, 64, 93, 95, 60, 79, 54, 26, 30, 44, 64, 71};
    }

    @Test
    public void testMergeTriplets() {
        //[[1,5,7],[3,10,1]]
        //[3,5,7]
        Solution solution = new Solution();
        int[][] ints = new int[2][3];
        int[] ints1 = new int[]{1,5,7};
        int[] ints2 = new int[]{3,1,10};
        ints[0] = ints1;
        ints[1] = ints2;
        int[] target = new int[]{3,5,7};
        System.out.println(solution.mergeTriplets(ints,target));
    }
}