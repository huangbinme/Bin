package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_714Test {

    @Test
    public void testMaxProfit() {
        Solution_714 solution714 = new Solution_714();
        System.out.println(solution714.maxProfit(new int[]{1,3,2,8,4,9},2));
    }
}