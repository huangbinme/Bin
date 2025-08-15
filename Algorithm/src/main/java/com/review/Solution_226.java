package com.review;

public class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode l = root.left, r = root.right;
        root.right = l;
        root.left = r;
        invertTree(l);
        invertTree(r);
        return root;
    }
}
