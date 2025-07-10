package com.review;

public class Solution_230 {
    Integer ans;

    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null || ans != null) return;
        dfs(node.left, k);
        count++;
        if (count == k) {
            ans = node.val;
        }
        dfs(node.right, k);
    }
}
