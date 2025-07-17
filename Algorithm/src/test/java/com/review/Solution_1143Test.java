package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_1143Test {

    @Test
    public void testLongestCommonSubsequence() {
        Solution_1143 solution1143 = new Solution_1143();
        System.out.println(solution1143.longestCommonSubsequence("abcde","bace"));
    }
}