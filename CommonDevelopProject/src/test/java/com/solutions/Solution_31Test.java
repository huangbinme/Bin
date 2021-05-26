package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_31Test {

    @Test
    public void testNextPermutation() {
        Solution_31 solution_31 = new Solution_31();
        int[] ints = new int[]{2,2,7,5,4,3,2,2,1};
        solution_31.nextPermutation(ints);
        int i = 0;
    }
}