package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_50Test {

    @Test
    public void testMyPow() {
        Solution_50 solution50 = new Solution_50();
        System.out.println(solution50.myPow(0.00001, 2147483647));
    }
}