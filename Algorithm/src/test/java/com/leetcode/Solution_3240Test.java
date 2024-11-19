package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_3240Test {

    @Test
    public void testMinFlips() {
        Solution_3240 solution3240 = new Solution_3240();
        int[][] ints = new int[4][];
        ints[0] = new int[]{0};
        ints[1] = new int[]{1};
        ints[2] = new int[]{};
        ints[3] = new int[]{0};
        System.out.println(solution3240.minFlips(ints));
    }
}