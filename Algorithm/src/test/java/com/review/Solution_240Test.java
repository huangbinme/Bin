package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_240Test {

    @Test
    public void testGetRemovableIndices() {
        Solution_240 solution240 = new Solution_240();
        Solution_240.getRemovableIndices("aabbb", "aabb");
    }
}