package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_46Test {

    @Test
    public void testPermute() {
        int[] nums = new int[]{1,2,3};
        Solution_46 solution_46 = new Solution_46();
        System.out.println(solution_46.permute(nums));
    }
}