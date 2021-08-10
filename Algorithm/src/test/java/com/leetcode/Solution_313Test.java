package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_313Test {

    @Test
    public void testNthSuperUglyNumber() {
        Solution_313 solution_313 = new Solution_313();
        solution_313.nthSuperUglyNumber(12, new int[]{2,7,13,19});
    }
}