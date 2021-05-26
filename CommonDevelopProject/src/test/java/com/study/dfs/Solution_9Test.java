package com.study.dfs;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_9Test {

    @Test
    public void testBuildTree() {
        int[] ints1 = new int[]{3,9,20,15,7};
        int[] ints2 = new int[]{9,3,15,20,7};
        Solution_9 solution_9 = new Solution_9();
        TreeNode treeNode = solution_9.buildTree(ints1,ints2);
        System.out.println("");
    }
}