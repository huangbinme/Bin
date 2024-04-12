package com.leetcode;

import junit.framework.TestCase;

import java.util.Arrays;

public class Solution_1766Test extends TestCase {

    public void testGetCoprimes() {
        Solution_1766 solution1766 = new Solution_1766();
        int[] ints = new int[]{9,16,30,23,33,35,9,47,39,46,16,38,5,49,21,44,17,1,6,37,49,15,23,46,38,9,27,3,24,1,14,17,12,23,43,38,12,4,8,17,11,18,26,22,49,14,9};
        int[][] ints1 = new int[6][];
        ints1[0] = new int[]{0, 1};
        ints1[1] = new int[]{0, 2};
        ints1[2] = new int[]{1, 3};
        ints1[3] = new int[]{1, 4};
        ints1[4] = new int[]{2, 5};
        ints1[5] = new int[]{2, 6};
        System.out.println(Arrays.toString(solution1766.getCoprimes(ints, ints1)));
    }
}