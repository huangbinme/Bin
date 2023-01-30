package com.leetcode;

public class Solution_98 {
    Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (pre != null && pre >= root.val) return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}
