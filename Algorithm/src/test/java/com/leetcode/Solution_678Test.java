package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_678Test {

    @Test
    public void testCheckValidString() {
        Solution_678 solution_678 = new Solution_678();
        System.out.println(solution_678.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }
}