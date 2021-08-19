package com.leetcode.offer;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_66Test {

    @Test
    public void testConstructArr() {
        Solution_66 solution_66 = new Solution_66();
        System.out.println(Arrays.toString(solution_66.constructArr(new int[]{1,2,3,4,5})));
    }
}