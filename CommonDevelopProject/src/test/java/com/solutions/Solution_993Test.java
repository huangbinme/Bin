package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_993Test {

    @Test
    public void testIsCousins() {
        TreeNode treeNode1  = new TreeNode(1);
        TreeNode treeNode2  = new TreeNode(2);
        TreeNode treeNode3  = new TreeNode(3);
        TreeNode treeNode4  = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        Solution_993 solution_993 = new Solution_993();
        System.out.println(solution_993.isCousins(treeNode1,4,3));

    }
}