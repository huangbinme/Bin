package com.leetcode;

public class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        }
        return left.val == right.val && check(left.left,right.right) && check(left.right,right.left);
    }
}
