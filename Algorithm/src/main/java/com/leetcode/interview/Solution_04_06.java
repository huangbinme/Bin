package com.leetcode.interview;

public class Solution_04_06 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return dfs(root, p);
    }

    private TreeNode dfs(TreeNode treeNode, TreeNode target) {
        if (treeNode == null) return null;
        if (treeNode.val <= target.val) return dfs(treeNode.right, target);
        TreeNode t2 = dfs(treeNode.left, target);
        return t2 == null ? treeNode : t2;
    }
}
