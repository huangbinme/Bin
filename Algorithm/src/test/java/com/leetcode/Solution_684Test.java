package com.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_684Test {

    @Test
    public void testFindRedundantConnection() {
        Solution_684 solution684 = new Solution_684();
        int[][] ints = new int[5][];
        ints[0] = new int[]{1, 2};
        ints[1] = new int[]{2, 3};
        ints[2] = new int[]{3, 4};
        ints[3] = new int[]{1, 4};
        ints[4] = new int[]{1, 5};
        System.out.println(Arrays.toString(solution684.findRedundantConnection(ints)));
    }
}