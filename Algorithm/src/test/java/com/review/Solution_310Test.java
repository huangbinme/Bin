package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_310Test {

    @Test
    public void testFindMinHeightTrees() {
        Solution_310 solution310 = new Solution_310();
        int[][] ints = new int[2][2];
        ints[0] = new int[]{0, 1};
        ints[1] = new int[]{0, 2};
        System.out.println(solution310.findMinHeightTrees(3,ints));
    }
}