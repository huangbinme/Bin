package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_787Test {

    @Test
    public void testFindCheapestPrice() {
        Solution_787 solution787 = new Solution_787();
        int[][] ints = new int[5][];
        ints[0] = new int[]{0, 1, 100};
        ints[1] = new int[]{1, 2, 100};
        ints[2] = new int[]{2, 0, 100};
        ints[3] = new int[]{1, 3, 600};
        ints[4] = new int[]{2, 3, 200};
//        ints[5] = new int[]{4, 2, 1};
        System.out.println(solution787.findCheapestPrice(4, ints, 0, 3, 1));
    }
}