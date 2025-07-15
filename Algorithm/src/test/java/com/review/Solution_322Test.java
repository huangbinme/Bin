package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_322Test {

    @Test
    public void testCoinChange() {
        Solution_322 s  = new Solution_322();
        System.out.println(s.coinChange(new int[]{1,2,5},11));
    }
}