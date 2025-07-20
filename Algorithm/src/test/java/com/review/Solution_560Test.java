package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_560Test {

    @Test
    public void testSubarraySum() {
        Solution_560 solution560 = new Solution_560();
        System.out.println(solution560.subarraySum(new int[]{1,2,1,2,1},3));
        //1,1,1,2,2
    }
}