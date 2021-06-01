package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_325Test {

    @Test
    public void testMaxSubArrayLen() {
        Solution_325 solution_325 = new Solution_325();
        System.out.println(solution_325.maxSubArrayLen(new int[]{-2, -1, 2, 1},1));
    }
}