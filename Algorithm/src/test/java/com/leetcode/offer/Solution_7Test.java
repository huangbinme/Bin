package com.leetcode.offer;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_7Test {

    @Test
    public void testBuildTree() {
        Solution_7 solution_7 = new Solution_7();
        int[] ints = new int[]{3,9,20,15,7};
        int[] ints2 = new int[]{9,3,15,20,7};
        TreeNode treeNode = solution_7.buildTree(ints,ints2);
        int i = 0;
    }
}