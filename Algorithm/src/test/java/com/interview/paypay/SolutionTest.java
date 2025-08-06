package com.interview.paypay;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 2, 1, 1}, 2);
    }
}