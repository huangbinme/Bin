package com.review;

public class Solution_104 {

    int ans = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return ans;
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode root, int deep) {
        if (root == null) return;
        dfs(root.right, deep + 1);
        ans = Math.max(ans, deep);
        dfs(root.left, deep + 1);
    }
}
