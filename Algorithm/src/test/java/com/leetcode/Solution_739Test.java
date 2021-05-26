package com.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution_739Test {

    @Test
    public void testDailyTemperatures() {
        Solution_739 solution_739 = new Solution_739();
        System.out.println(Arrays.toString(solution_739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}