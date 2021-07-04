package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_84Test {

    @Test
    public void testLargestRectangleArea() {
        Solution_84 solution_84 = new Solution_84();
        System.out.println(solution_84.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}