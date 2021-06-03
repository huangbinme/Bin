package com.leetcode.offer;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_38Test {

    @Test
    public void testPermutation() {
        Solution_38 solution_38 = new Solution_38();
        System.out.println(Arrays.toString(solution_38.permutation("ABA")));
    }
}