package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_974Test {

    @Test
    public void testSubarraysDivByK() {
        Solution_974 solution_974 = new Solution_974();
        System.out.println(solution_974.subarraysDivByK(new int[]{-1,2,9},2));
    }
}