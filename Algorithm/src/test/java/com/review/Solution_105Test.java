package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_105Test {

    @Test
    public void testBuildTree() {
        Solution_105 solution105 = new Solution_105();
        solution105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}