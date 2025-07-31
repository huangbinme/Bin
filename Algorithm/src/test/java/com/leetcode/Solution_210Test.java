package com.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_210Test {

    @Test
    public void testFindOrder() {
        Solution_210 solution210 = new Solution_210();
        int[][] ints = new int[4][2];
        ints[0] = new int[]{1, 0};
        ints[1] = new int[]{2, 0};
        ints[2] = new int[]{3, 1};
        ints[3] = new int[]{3, 2};
        System.out.println(Arrays.toString(solution210.findOrder(4, ints)));
    }
}