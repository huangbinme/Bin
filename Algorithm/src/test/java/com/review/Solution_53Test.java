package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_53Test {

    @Test
    public void testMaxSubArray() {
        Solution_53 solution53 = new Solution_53();
        System.out.println(solution53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}