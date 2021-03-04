package com.solutions;

import junit.framework.TestCase;

public class Solution_15Test extends TestCase {

    public void testThreeSum() {
        int[] input = new int[]{-1,0,1,2,-1,-4};
        Solution_15 solution_15 = new Solution_15();
        solution_15.threeSum(input);
    }
}