package com.leetcode;

public class Solution_110 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root, 1) != -1;
    }

    private int dfs(TreeNode root, int deep) {
        if (root == null) return deep;
        int i = dfs(root.left, deep + 1);
        if (i == -1) return -1;
        int j = dfs(root.right, deep + 1);
        if (j == -1) return -1;
        if (Math.abs(i - j) > 1) return -1;
        return Math.max(i, j);
    }
}
