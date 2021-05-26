package com.leetcode;

import junit.framework.TestCase;

public class Solution_300Test extends TestCase {

    public void testLengthOfLIS() {
        Solution_300 solution_300 = new Solution_300();
        int[] input = new int[]{4,10,4,3,8,9};
        solution_300.lengthOfLIS(input);
    }
}