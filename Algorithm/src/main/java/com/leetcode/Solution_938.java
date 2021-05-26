package com.leetcode;

public class Solution_938 {
    int ans = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return ans;
    }

    private void traverse(TreeNode root, int low, int high) {
        if (root == null) return;
        if (root.val <= high && root.val >= low) {
            ans += root.val;
            traverse(root.left, low, high);
            traverse(root.right, low, high);
        } else if (root.val > high) {
            traverse(root.left, low, high);
        } else {
            traverse(root.right, low, high);
        }
    }
}
