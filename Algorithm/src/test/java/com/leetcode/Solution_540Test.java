package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_540Test {

    @Test
    public void testSingleNonDuplicate() {
        Solution_540 solution540 = new Solution_540();
        System.out.println(solution540.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }
}