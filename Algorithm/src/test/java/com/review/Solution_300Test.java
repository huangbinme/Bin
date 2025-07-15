package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_300Test {

    @Test
    public void testLengthOfLIS() {
        Solution_300 solution300 = new Solution_300();
        System.out.println(solution300.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}