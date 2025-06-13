package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_15Test {

    @Test
    public void testThreeSum() {
        Solution_15 solution15 = new Solution_15();
        solution15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}