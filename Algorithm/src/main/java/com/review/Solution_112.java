package com.review;

public class Solution_112 {

    boolean ans = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        dfs(root, targetSum, 0);
        return ans;
    }

    private void dfs(TreeNode treeNode, int targetSum, int sum) {
        if (ans) return;
        if (treeNode.right == null && treeNode.left == null) {
            sum += treeNode.val;
            ans = sum == targetSum;
            return;
        }
        if (treeNode.left != null) dfs(treeNode.left, targetSum, sum + treeNode.val);
        if (treeNode.right != null) dfs(treeNode.right, targetSum, sum + treeNode.val);
    }
}
