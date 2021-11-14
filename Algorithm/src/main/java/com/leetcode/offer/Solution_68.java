package com.leetcode.offer;

public class Solution_68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode treeNode, TreeNode p, TreeNode q) {
        if (treeNode == null) return null;
        if (treeNode == p || treeNode == q) return treeNode;
        TreeNode t1 = dfs(treeNode.left, p, q);
        TreeNode t2 = dfs(treeNode.right, p, q);
        if (t1 != null && t2 != null) return treeNode;
        if (t1 == null && t2 == null) return null;
        return t1 != null ? t1 : t2;
    }
}
