package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_32Test {

    @Test
    public void testLongestValidParentheses() {
        Solution_32 solution32 = new Solution_32();
        System.out.println(solution32.longestValidParentheses("(()()"));
    }
}