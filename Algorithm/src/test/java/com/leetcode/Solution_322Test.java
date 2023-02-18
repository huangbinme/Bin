package com.leetcode;

import org.testng.annotations.Test;

public class Solution_322Test {

    @Test
    public void testCoinChange() {
        Solution_322 solution322 = new Solution_322();
        System.out.println(solution322.coinChange(new int[]{2, 5, 10, 1}, 27));
    }
}