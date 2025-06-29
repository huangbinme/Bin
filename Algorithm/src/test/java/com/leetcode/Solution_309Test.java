package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_309Test {

    @Test
    public void testMaxProfit() {
        Solution_309 solution309 = new Solution_309();
        System.out.println(solution309.maxProfit(new int[]{1,2,3,0,2}));
    }
}