package com.review;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_239Test {

    @Test
    public void testMaxSlidingWindow() {
        Solution_239 solution239 = new Solution_239();
        System.out.println(Arrays.toString(solution239.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}