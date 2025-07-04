package com.review;

import java.util.Arrays;

public class Solution_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) return null;
        TreeNode treeNode = new TreeNode(postorder[postorder.length - 1]);
        int rootVIndex = 0;
        while (inorder[rootVIndex] != treeNode.val) rootVIndex++;
        int[] lInOrder = Arrays.copyOfRange(inorder, 0, rootVIndex);
        int[] rInOrder = Arrays.copyOfRange(inorder, rootVIndex + 1, inorder.length);
        int[] lPostOrder = Arrays.copyOfRange(postorder, 0, lInOrder.length);
        int[] rPostOrder = Arrays.copyOfRange(postorder, lPostOrder.length, postorder.length - 1);
        treeNode.left = buildTree(lInOrder, lPostOrder);
        treeNode.right = buildTree(rInOrder, rPostOrder);
        return treeNode;
    }
}
