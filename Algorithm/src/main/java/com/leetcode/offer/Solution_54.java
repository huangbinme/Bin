package com.leetcode.offer;

public class Solution_54 {
    Integer ans;
    int record = 0;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null || ans != null) return;
        dfs(root.right, k);
        record++;
        if (record == k) {
            ans = root.val;
            return;
        }
        dfs(root.left, k);
    }
}
