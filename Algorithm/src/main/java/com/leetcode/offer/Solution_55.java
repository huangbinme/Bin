package com.leetcode.offer;

public class Solution_55 {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode treeNode, int i) {
        if (treeNode == null) return i;
        return Math.max(dfs(treeNode.right, i + 1), dfs(treeNode.left, i + 1));
    }
}
