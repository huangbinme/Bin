package com.study.dfs;

public class Solution_6 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == null && right == null;

        if (isLeafNode(left)) {
            return isLeafNode(right) && left.val == right.val;
        }

        if (isLeafNode(right)) {
            return isLeafNode(left) && left.val == right.val;
        }
        boolean a = left.val == right.val;
        boolean b = check(left.left, right.right) && check(left.right, right.left);
        return a && b;
    }

    private boolean isLeafNode(TreeNode treeNode) {
        return treeNode != null && treeNode.left == null && treeNode.right == null;
    }
}
