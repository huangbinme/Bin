package com.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_503Test {

    @Test
    public void testNextGreaterElements() {
        Solution_503 solution_503 = new Solution_503();
        System.out.println(Arrays.toString(solution_503.nextGreaterElements(new int[]{2,1,2,4,3})));
    }
}