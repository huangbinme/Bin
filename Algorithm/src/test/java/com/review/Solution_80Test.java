package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_80Test {

    @Test
    public void testRemoveDuplicates() {
        Solution_80 solution80 = new Solution_80();
        System.out.println(solution80.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }
}