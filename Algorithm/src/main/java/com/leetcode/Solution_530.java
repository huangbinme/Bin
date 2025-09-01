package com.leetcode;

public class Solution_530 {

    TreeNode pre;

    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) return;
        dfs(treeNode.left);
        if (pre == null) {
            pre = treeNode;
        } else {
            ans = Math.min(ans, Math.abs(pre.val - treeNode.val));
            pre = treeNode;
        }
        dfs(treeNode.right);
    }
}
