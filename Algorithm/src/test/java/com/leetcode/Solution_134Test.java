package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_134Test {

    @Test
    public void testCanCompleteCircuit() {
        Solution_134  solution134 = new Solution_134();
        System.out.println(solution134.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}