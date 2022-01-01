package com.leetcode.offer;

public class Solution_55 {
    boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        deep(root, 0);
        return ans;
    }

    public int deep(TreeNode t, int d) {
        if (t == null) return d;
        int l = deep(t.left, d + 1);
        int r = deep(t.right, d + 1);
        if (Math.abs(l - r) > 1) ans = false;
        return Math.max(l, r);
    }
}
