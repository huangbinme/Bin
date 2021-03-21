package com.solutions;

public class Solution_04 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.right) - height(root.left)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return Math.max(height(treeNode.right), height(treeNode.left)) + 1;
    }
}
