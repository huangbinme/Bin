package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_108Test {

    @Test
    public void testSortedArrayToBST() {
        Solution_108 solution108 = new Solution_108();
        int[] ints = new int[]{-10,-3,0,5,9};
        solution108.sortedArrayToBST(ints);
    }
}