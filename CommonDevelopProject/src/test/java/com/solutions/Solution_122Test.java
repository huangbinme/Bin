package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_122Test {

    @Test
    public void testMaxProfit() {
        Solution_122 solution_122 = new Solution_122();
        int[] ints = new int[]{5,4,3,2,1};
        System.out.println(solution_122.maxProfit(ints));
    }
}