package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_41Test {

    @Test
    public void testFirstMissingPositive() {
        Solution_41 solution41 = new Solution_41();
        System.out.println(solution41.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}