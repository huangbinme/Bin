package com.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_3152Test {

    @Test
    public void testIsArraySpecial() {
        Solution_3152 solution3152 = new Solution_3152();
        int[][] ints = new int[1][];
        ints[0] = new int[]{1, 3};
        System.out.println(Arrays.toString(solution3152.isArraySpecial(new int[]{2,2,6,2,4}, ints)));
    }
}