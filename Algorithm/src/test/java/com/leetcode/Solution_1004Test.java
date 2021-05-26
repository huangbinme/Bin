package com.leetcode;

import org.testng.annotations.Test;

public class Solution_1004Test {

    @Test
    public void testLongestOnes() {
        Solution_1004 solution_1004 = new Solution_1004();
        System.out.println(solution_1004.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}