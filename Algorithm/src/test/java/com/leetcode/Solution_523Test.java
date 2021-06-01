package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_523Test {

    @Test
    public void testCheckSubarraySum() {
        Solution_523 solution_523 = new Solution_523();
        System.out.println(solution_523.checkSubarraySum(new int[]{5,0,0,0},3));
    }
}