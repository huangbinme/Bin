package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_1004Test {

    @Test
    public void testLongestOnes() {
        Solution_1004 solution1004 = new Solution_1004();
        System.out.println(solution1004.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }
}