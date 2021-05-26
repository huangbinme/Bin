package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_16Test {

    @Test
    public void testThreeSumClosest() {
        Solution_16 solution_16 = new Solution_16();
        System.out.println(solution_16.threeSumClosest(new int[]{0,2,1,-3},1));
    }
}