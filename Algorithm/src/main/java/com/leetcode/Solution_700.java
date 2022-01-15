package com.leetcode;

public class Solution_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }

    private TreeNode dfs(TreeNode treeNode, int val) {
        if (treeNode == null || treeNode.val == val) return treeNode;
        TreeNode l = dfs(treeNode.left, val);
        TreeNode r = dfs(treeNode.right, val);
        return l == null ? r : l;
    }
}
