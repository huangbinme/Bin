package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_1248Test {

    @Test
    public void testNumberOfSubarrays() {
        Solution_1248 solution_1248 = new Solution_1248();
        System.out.println(solution_1248.numberOfSubarrays(new int[]{1,1,2,1,1},3));
    }
}