package com.leetcode;

public class Solution_993 {
    int xParent = 0, xDeep = 0, yParent = 0, yDeep = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root.left, x, y, 1, root.val);
        dfs(root.right, x, y, 1, root.val);
        return xParent != yParent && xDeep == yDeep;
    }

    private void dfs(TreeNode treeNode, int x, int y, int deep, int par) {
        if (treeNode == null) return;
        if (treeNode.val == x) {
            xDeep = deep;
            xParent = par;
        }
        if (treeNode.val == y) {
            yParent = par;
            yDeep = deep;
        }
        dfs(treeNode.right, x, y, deep + 1, treeNode.val);
        dfs(treeNode.left, x, y, deep + 1, treeNode.val);
    }
}
