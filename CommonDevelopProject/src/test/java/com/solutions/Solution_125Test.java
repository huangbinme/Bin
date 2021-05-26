package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_125Test {

    @Test
    public void testIsPalindrome() {
        Solution_125 solution_125 = new Solution_125();
        solution_125.isPalindrome("A man, a plan, a canal: Panama");
    }
}