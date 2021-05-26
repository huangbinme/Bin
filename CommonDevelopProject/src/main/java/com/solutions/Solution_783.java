package com.solutions;

public class Solution_783 {
    int result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode treeNode) {
        if (isLeafNode(treeNode)) {
            return;
        }
        if (treeNode.left != null) {
            int leftMax = max(treeNode.left);
            result = Math.min(result, Math.abs(treeNode.val - leftMax));
            dfs(treeNode.left);
        }
        if (treeNode.right != null) {
            int rightMin = min(treeNode.right);
            result = Math.min(result, Math.abs(treeNode.val - rightMin));
            dfs(treeNode.right);
        }
    }

    private int max(TreeNode treeNode) {
        if (treeNode.right == null) return treeNode.val;
        return max(treeNode.right);
    }

    private int min(TreeNode treeNode) {
        if (treeNode.left == null) return treeNode.val;
        return min(treeNode.left);
    }

    private boolean isLeafNode(TreeNode treeNode) {
        return treeNode != null && treeNode.left == null && treeNode.right == null;
    }
}
