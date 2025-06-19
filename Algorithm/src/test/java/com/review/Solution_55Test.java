package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_55Test {

    @Test
    public void testCanJump() {
        Solution_55 solution55 = new Solution_55();
        solution55.canJump(new int[]{3, 2, 1, 0, 4});
    }
}