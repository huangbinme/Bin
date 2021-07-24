package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_713Test {

    @Test
    public void testNumSubarrayProductLessThanK() {
        Solution_713 solution_713 = new Solution_713();
        System.out.println(solution_713.numSubarrayProductLessThanK(new int[]{10,5,2,6},100));
    }
}