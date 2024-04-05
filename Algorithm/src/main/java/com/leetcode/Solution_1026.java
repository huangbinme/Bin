package com.leetcode;

public class Solution_1026 {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if(root == null) return Math.abs(max - min);
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int i = dfs(root.left, min , max);
        int j = dfs(root.right, min , max);
        return Math.max(i, j);
    }
}
