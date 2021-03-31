package com.study.dfs;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_4Test {

    @Test
    public void testInvertTree() {
        TreeNode treeNode = new TreeNode(1);

        TreeNode treeNode2 = new TreeNode(2);
        treeNode.left = treeNode2;
        Solution_4 solution_4 = new Solution_4();
        solution_4.invertTree(treeNode);
    }
}