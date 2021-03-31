package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_26Test {

    @Test
    public void testRemoveDuplicates() {
        Solution_26 solution_26 = new Solution_26();
        int[] ints = new int[]{1,1,2};
        solution_26.removeDuplicates(ints);
    }
}