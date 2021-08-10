package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_581Test {

    @Test
    public void testFindUnsortedSubarray() {
        Solution_581 solution_581 = new Solution_581();
        System.out.println(solution_581.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }
}