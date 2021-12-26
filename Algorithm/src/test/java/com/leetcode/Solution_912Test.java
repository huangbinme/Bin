package com.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_912Test {

    @Test
    public void testSortArray() {
        Solution_912 solution_912 = new Solution_912();
        System.out.println(Arrays.toString(solution_912.sortArray(new int[]{5,2,3,1})));
    }
}