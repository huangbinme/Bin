package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_447Test {

    @Test
    public void testNumberOfBoomerangs() {
        Solution_447 solution_447 = new Solution_447();
        int[][] ints = new int[3][2];
        ints[0] = new int[]{0,0};
        ints[1] = new int[]{1,0};
        ints[2] = new int[]{2,0};
        System.out.println(solution_447.numberOfBoomerangs(ints));
    }
}