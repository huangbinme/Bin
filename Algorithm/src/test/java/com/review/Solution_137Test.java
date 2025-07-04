package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_137Test {

    @Test
    public void testSingleNumber() {
        Solution_137 solution137 = new Solution_137();
        System.out.println(solution137.singleNumber(new int[]{2,2,3,2}));
    }
}