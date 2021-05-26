package com.leetcode;

import org.testng.annotations.Test;

public class Solution_1052Test {

    @Test
    public void testMaxSatisfied() {
        Solution_1052 solution_1052 = new Solution_1052();
        solution_1052.maxSatisfied(new int[]{5,8},new int[]{0,1},1);
    }

    @Test
    public void testMaxSatisfied2() {
        Solution_1052 solution_1052 = new Solution_1052();
        System.out.println(solution_1052.maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3));
    }
}