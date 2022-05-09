package com.leetcode;

public class Solution_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null || root2 == null) return root1 == null ? root2 : root1;
        int sum = root1.val + root2.val;
        TreeNode c = new TreeNode(sum);
        c.left = dfs(root1.left, root2.left);
        c.right = dfs(root1.right, root2.right);
        return c;
    }
}
