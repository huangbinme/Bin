package com.study.dfs;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_8Test {

    @Test
    public void testLowestCommonAncestor() {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode3.right = treeNode1;
        treeNode3.left = treeNode5;

        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;

        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;

        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;

        Solution_8 solution_8 = new Solution_8();
        solution_8.lowestCommonAncestor(treeNode3,treeNode6,treeNode4);
    }

    @Test
    public void testLowestCommonAncestor2() {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode0.right = treeNode1;
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;

        Solution_8 solution_8 = new Solution_8();
        solution_8.lowestCommonAncestor(treeNode0,treeNode2,treeNode3);
    }

}