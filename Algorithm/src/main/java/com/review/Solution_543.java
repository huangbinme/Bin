package com.review;

public class Solution_543 {

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    private int dfs(TreeNode treeNode, int deep) {
        if (treeNode == null) return deep - 1;
        int l = dfs(treeNode.left, deep + 1);
        int r = dfs(treeNode.right, deep + 1);
        int path = l - deep + r - deep;
        ans = Math.max(path, ans);
        return Math.max(l, r);
    }
}
