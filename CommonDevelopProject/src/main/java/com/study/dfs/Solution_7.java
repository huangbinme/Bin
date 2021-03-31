package com.study.dfs;

public class Solution_7 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sum(root, 0);
        return sum;
    }

    private void sum(TreeNode root, int valueOf) {
        if (isLeafNode(root)) {
            sum = sum + valueOf * 10 + root.val;
            return;
        }
        if (root.left != null) {
            sum(root.left, valueOf * 10 + root.val);
        }

        if (root.right != null) {
            sum(root.right, valueOf * 10 + root.val);
        }
    }

    private boolean isLeafNode(TreeNode treeNode) {
        return treeNode != null && treeNode.left == null && treeNode.right == null;
    }
}
