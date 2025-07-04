package com.review;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution_113Test {

    @Test
    public void testPathSum() {
        Solution_113 s = new Solution_113();
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;

        List<List<Integer>> lists = s.pathSum(treeNode1, 8);
        int i = 0;
    }
}