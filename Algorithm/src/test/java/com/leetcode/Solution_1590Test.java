package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_1590Test {

    @Test
    public void testMinSubarray() {
        Solution_1590 solution1590 = new Solution_1590();

        //1000000000,
        //1000000000,
        //1000000000
        //2147483647
        System.out.println(solution1590.minSubarray(new int[]{26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3}, 26));
    }
}