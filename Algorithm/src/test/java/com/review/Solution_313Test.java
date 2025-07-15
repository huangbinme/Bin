package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_313Test {

    @Test
    public void testNthSuperUglyNumber() {
        Solution_313 solution313 = new Solution_313();
        System.out.println(solution313.nthSuperUglyNumber(5911, new int[]{2,3,5,7}));
    }
}