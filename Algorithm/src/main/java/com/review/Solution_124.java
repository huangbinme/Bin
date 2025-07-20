package com.review;

public class Solution_124 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode treeNode) {
        if(treeNode == null) return 0;
        int l = dfs(treeNode.left);
        int r = dfs(treeNode.right);
        ans = Math.max(ans, treeNode.val + l + r);
        return Math.max(0, Math.max(treeNode.val + l, treeNode.val + r));//如果要对父节点有贡献，只能选择左右两边的一条路
    }
}
