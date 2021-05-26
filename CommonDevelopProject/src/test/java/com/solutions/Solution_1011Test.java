package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_1011Test {

    @Test
    public void testShipWithinDays() {
        Solution_1011 solution_1011 = new Solution_1011();
        System.out.println(solution_1011.shipWithinDays(new int[]{3,2,2,4,1,4},3));
    }

    @Test
    public void testTestShipWithinDays() {
    }
}