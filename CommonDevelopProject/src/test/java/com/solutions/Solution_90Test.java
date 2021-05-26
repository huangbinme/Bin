package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_90Test {

    @Test
    public void testSubsetsWithDup() {
        Solution_90 solution_90 = new Solution_90();
        solution_90.subsetsWithDup(new int[]{1,2,2});
    }
}