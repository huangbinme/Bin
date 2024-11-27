package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_3208Test {

    @Test
    public void testNumberOfAlternatingGroups() {
        Solution_3208 solution3208 = new Solution_3208();
        int[] ints = new int[]{1,1,0,1};
        System.out.println(solution3208.numberOfAlternatingGroups(ints, 4));
    }
}