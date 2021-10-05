package com.leetcode.offer;

public class Solution_28 {
    boolean ans = true;

    public boolean isSymmetric(TreeNode root) {
        dfs(root.left, root.right);
        return ans;
    }

    private void dfs(TreeNode left, TreeNode right) {
        if (!ans) return;
        if (left == null || right == null) {
            ans = left == right;
            return;
        }
        ans = left.val == right.val;
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}
