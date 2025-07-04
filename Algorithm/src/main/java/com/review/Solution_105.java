package com.review;

import java.util.Arrays;

public class Solution_105 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        while (inorder[i] != root.val) i++;
        int[] lInOrder = Arrays.copyOfRange(inorder, 0, i);
        int[] rInOrder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        int[] lPreOrder = Arrays.copyOfRange(preorder, 1, 1 + lInOrder.length);
        int[] rPreOrder = Arrays.copyOfRange(preorder, lPreOrder.length + 1, preorder.length);
        root.right = buildTree(rPreOrder, rInOrder);
        root.left = buildTree(lPreOrder, lInOrder);
        return root;
    }
}
