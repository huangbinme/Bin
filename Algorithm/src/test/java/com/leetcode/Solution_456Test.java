package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_456Test {

    @Test
    public void testFind132pattern() {
        Solution_456 solution_456 = new Solution_456();
        System.out.println(solution_456.find132pattern(new int[]{-1,3,2,0}));
    }
}