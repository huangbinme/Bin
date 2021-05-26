package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_323Test {

    @Test
    public void testCountComponents() {
        Solution_323 solution_323 = new Solution_323();
        int[][] ints = new int[1][1];
        ints[0] = new int[]{1,0};
        solution_323.countComponents(2,ints);
    }
}