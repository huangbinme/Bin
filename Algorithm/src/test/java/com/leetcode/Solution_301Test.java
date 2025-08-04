package com.leetcode;

import org.testng.annotations.Test;

public class Solution_301Test {

    @Test
    public void testRemoveInvalidParentheses() {
        Solution_301 solution301 = new Solution_301();
        System.out.println(solution301.removeInvalidParentheses("()())()"));
        Solution_301 solution3012 = new Solution_301();
        System.out.println(solution3012.removeInvalidParentheses("(a)())()"));

        Solution_301 solution3013 = new Solution_301();
        System.out.println(solution3013.removeInvalidParentheses(")(f"));
    }
}