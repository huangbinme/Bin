package com.leetcode;

import org.testng.annotations.Test;

public class Solution_04Test {

    @Test
    public void testIsBalanced() {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        Solution_04 solution_04 = new Solution_04();
        solution_04.isBalanced(treeNode1);
    }

    @Test
    public void testIsBalanced2() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        Solution_04 solution_04 = new Solution_04();
        solution_04.isBalanced(treeNode1);
    }
}