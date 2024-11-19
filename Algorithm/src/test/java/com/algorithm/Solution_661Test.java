package com.algorithm;

import com.leetcode.Solution_661;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_661Test {

    @Test
    public void testImageSmoother() {
        Solution_661 solution661 = new Solution_661();
        int[][] ints = new int[3][];
        ints[0] = new int[]{1, 1, 1};
        ints[1] = new int[]{1, 0, 1};
        ints[2] = new int[]{1, 1, 1};
        solution661.imageSmoother(ints);
    }
}