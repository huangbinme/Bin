package com.leetcode;

import org.testng.annotations.Test;

public class Solution_80Test {

    @Test
    public void testRemoveDuplicates() {
        Solution_80 solution_80 = new Solution_80();
        System.out.println(solution_80.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}