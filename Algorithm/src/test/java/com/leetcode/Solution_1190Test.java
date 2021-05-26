package com.leetcode;

import org.testng.annotations.Test;

public class Solution_1190Test {

    @Test
    public void testReverseParentheses() {
        Solution_1190 solution_1190 = new Solution_1190();
        solution_1190.reverseParentheses("a(bcdefghijkl(mno)p)q");
    }
}