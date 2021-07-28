package com.leetcode;

public class Solution_671 {
    int ans = -1;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        traverse(root, root.val);
        return ans;
    }

    private void traverse(TreeNode treeNode, int root) {
        if (treeNode == null) return;
        if (treeNode.val != root) {
            ans = ans == -1 ? treeNode.val : Math.min(ans, treeNode.val);
        }
        traverse(treeNode.left, root);
        traverse(treeNode.right, root);
    }
}
