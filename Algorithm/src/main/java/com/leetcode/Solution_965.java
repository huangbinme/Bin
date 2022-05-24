package com.leetcode;

public class Solution_965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        int rootValue = root.val;
        return dfs(root, rootValue);
    }

    private boolean dfs(TreeNode root, int rootValue) {
        if (root == null) return true;
        if (root.val != rootValue) return false;
        return dfs(root.right, rootValue) && dfs(root.left, rootValue);
    }
}
