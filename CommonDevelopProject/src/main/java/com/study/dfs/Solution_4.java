package com.study.dfs;

public class Solution_4 {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root) {
        if (root == null || isLeafNode(root)) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        reverse(root.left);
        reverse(root.right);
    }

    private boolean isLeafNode(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }
}
