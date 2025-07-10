package com.review;

public class Solution_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        if (l != null && r != null) {
            return root;
        }
        return l != null ? l : r;
    }
}
