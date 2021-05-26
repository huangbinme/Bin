package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_1190Test {

    @Test
    public void testReverseParentheses() {
        Solution_1190 solution_1190 = new Solution_1190();
        solution_1190.reverseParentheses("a(bcdefghijkl(mno)p)q");
    }
}