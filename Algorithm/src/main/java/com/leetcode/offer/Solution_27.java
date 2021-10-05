package com.leetcode.offer;

public class Solution_27 {
    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) return;
        TreeNode tmp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = tmp;
        dfs(treeNode.left);
        dfs(treeNode.right);
    }
}
