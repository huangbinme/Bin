package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_199Test {

    @Test
    public void testRightSideView() {
        Solution_199 solution_199 = new Solution_199();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        solution_199.rightSideView(treeNode1);
    }
}