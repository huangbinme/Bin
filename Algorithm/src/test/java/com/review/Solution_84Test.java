package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_84Test {

    @Test
    public void testLargestRectangleArea() {
        Solution_84 s = new Solution_84();
        s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }
}