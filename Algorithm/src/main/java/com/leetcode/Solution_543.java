package com.leetcode;

public class Solution_543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return ans;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root.right == null && root.left == null) {
            return 0;
        }
        int l = root.left == null ? 0 : dfs(root.left) + 1;
        int r = root.right == null ? 0 : dfs(root.right) + 1;
        ans = Math.max(ans, l + r);
        return Math.max(l, r);
    }
}
