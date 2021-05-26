package com.solutions;

import org.testng.annotations.Test;

public class SolutionTest {

    @Test
    public void testCheckZeroOnes() {
        Solution solution = new Solution();
        System.out.println(solution.checkZeroOnes("1"));
    }
}