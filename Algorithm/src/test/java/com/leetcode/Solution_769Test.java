package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_769Test {

    @Test
    public void testMaxChunksToSorted() {
        Solution_769 solution_769 = new Solution_769();
        System.out.println(solution_769.maxChunksToSorted(new int[]{1,0,2,3,4}));
    }
}