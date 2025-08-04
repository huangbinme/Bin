package com.interview.paypay;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_6Test {

    @Test
    public void testSolution() {
        String[] queries = new String[]{"v 1 2", "x 2 2", "v 1 2", "> 2 1", "x 2 3", "> 2 1", "< 2 0"};
        Solution_6 solution6 = new Solution_6();
        int[][] solution = solution6.solution(3, 5, queries);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(Arrays.toString(solution[i]));
        }
    }
}