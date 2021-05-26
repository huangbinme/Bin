package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_783Test {

    @Test
    public void testMinDiffInBST() {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode6;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        Solution_783 solution_783 = new Solution_783();
        solution_783.minDiffInBST(treeNode4);
    }
}