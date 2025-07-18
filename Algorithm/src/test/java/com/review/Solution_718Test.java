package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_718Test {

    @Test
    public void testFindLength() {
        Solution_718 solution718 = new Solution_718();
        solution718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
    }
}