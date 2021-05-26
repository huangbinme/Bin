package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_55Test {

    @Test
    public void testCanJump() {
        Solution_55 solution_55 = new Solution_55();
        int[] ints = new int[]{2,0};
        solution_55.canJump(ints);
    }
}