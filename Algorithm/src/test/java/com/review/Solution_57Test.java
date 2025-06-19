package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_57Test {

    @Test
    public void testInsert() {
        Solution_57 s = new Solution_57();
        int[][] ints = new int[2][];
        ints[0] = new int[]{1, 3};
        ints[1] = new int[]{6, 9};
        s.insert(ints, new int[]{2, 5});
    }
}