package com.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution_496Test {

    @Test
    public void testNextGreaterElement() {
        Solution_496 solution_496 = new Solution_496();
        System.out.println(Arrays.toString(solution_496.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}