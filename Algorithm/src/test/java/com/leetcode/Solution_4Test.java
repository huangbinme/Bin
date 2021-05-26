package com.leetcode;

import junit.framework.TestCase;

public class Solution_4Test extends TestCase {

    public void testFindMedianSortedArrays() {
        Solution_4 solution_4 = new Solution_4();
        int[] ints1 = new int[]{1, 3};
        int[] ints2 = new int[]{2};
        solution_4.findMedianSortedArrays(ints1, ints2);
    }
}