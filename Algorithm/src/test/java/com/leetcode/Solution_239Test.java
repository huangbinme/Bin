package com.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution_239Test {

    @Test
    public void testMaxSlidingWindow() {
        Solution_239 solution_239 = new Solution_239();
        System.out.println(Arrays.toString(solution_239.maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4)));
    }
}