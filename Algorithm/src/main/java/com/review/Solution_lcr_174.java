package com.review;

public class Solution_lcr_174 {

    int index = 0;

    int ans = 0;

    public int findTargetNode(TreeNode root, int cnt) {
        dfs(root, cnt);
        return ans;
    }

    private void dfs(TreeNode root, int find) {
        if (root == null || index > find) return;
        dfs(root.right, find);
        index++;
        if (index == find) {
            ans = root.val;
        }
        dfs(root.left, find);
    }
}
