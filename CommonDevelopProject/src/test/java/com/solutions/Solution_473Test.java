package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_473Test {

    @Test
    public void testMakesquare() {
        Solution_473 solution_473 = new Solution_473();
        System.out.println(solution_473.makesquare(new int[]{5,5,5,5,16,4,4,4,4,4,3,3,3,3,4}));
    }
}