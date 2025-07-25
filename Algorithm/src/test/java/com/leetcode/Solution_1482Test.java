package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_1482Test {

    @Test
    public void testMinDays() {
        Solution_1482 s = new Solution_1482();
        System.out.println(s.minDays(new int[]{1,10,2,9,3,8,4,7,5,6},4,2));
        System.out.println(s.minDays(new int[]{7,7,7,7,12,7,7},2,3));
        System.out.println(s.minDays(new int[]{1,10,3,10,2},3,1));
    }
}