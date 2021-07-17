package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_532Test {

    @Test
    public void testFindPairs() {
        Solution_532 solution_532 = new Solution_532();
        System.out.println(solution_532.findPairs(new int[]{1,2,4,4,3,3,0,9,2,3},3));
    }
}