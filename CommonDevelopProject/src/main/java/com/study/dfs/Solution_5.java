package com.study.dfs;

public class Solution_5 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        return check(p, q);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (isLeafNode(p)) return isLeafNode(q) && (p.val == q.val);
        if (isLeafNode(q)) return isLeafNode(p) && (p.val == q.val);
        if (p == null || q == null) return q == null && p == null;

        if (p.val == q.val) {
            boolean left = check(p.left, q.left);
            boolean right = check(p.right, q.right);
            return left && right;
        } else {
            return false;
        }
    }

    private boolean isLeafNode(TreeNode treeNode) {
        return treeNode != null && treeNode.left == null && treeNode.right == null;
    }
}
