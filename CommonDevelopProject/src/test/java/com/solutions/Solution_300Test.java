package com.solutions;

import junit.framework.TestCase;

public class Solution_300Test extends TestCase {

    public void testLengthOfLIS() {
        Solution_300 solution_300 = new Solution_300();
        int[] input = new int[]{1,3,6,7,9,4,10,5,6};
        solution_300.lengthOfLIS(input);
    }
}