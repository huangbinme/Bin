package com.leetcode;

public class Solution_563 {
    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int r = dfs(treeNode.right), l = dfs(treeNode.left);
        ans += Math.abs(r - l);
        return r + l + treeNode.val;
    }
}
