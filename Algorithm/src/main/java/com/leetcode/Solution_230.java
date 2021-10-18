package com.leetcode;

public class Solution_230 {
    int count = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode treeNode, int k) {
        if (treeNode == null) return;
        dfs(treeNode.left, k);
        count++;
        if (count > k) return;
        if (count == k) {
            ans = treeNode.val;
            return;
        }
        dfs(treeNode.right, k);
    }
}
