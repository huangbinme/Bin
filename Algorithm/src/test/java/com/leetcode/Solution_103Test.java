package com.leetcode;

import org.testng.annotations.Test;

public class Solution_103Test {

    @Test
    public void testZigzagLevelOrder() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;
        Solution_103 solution_103 = new Solution_103();
        solution_103.zigzagLevelOrder(treeNode1);
    }
}