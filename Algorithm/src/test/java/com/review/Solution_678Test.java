package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_678Test {

    @Test
    public void testCheckValidString() {
        Solution_678 solution678 = new Solution_678();
        solution678.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()");
    }
}