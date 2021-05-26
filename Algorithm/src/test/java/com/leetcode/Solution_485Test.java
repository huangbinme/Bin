package com.leetcode;

import org.testng.annotations.Test;

public class Solution_485Test {

    @Test
    public void testFindMaxConsecutiveOnes() {
        Solution_485 solution_485 = new Solution_485();
        System.out.println(solution_485.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 0, 1, 1, 1}));
    }
}