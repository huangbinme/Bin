package com.leetcode;

public class Solution_1022 {
    int ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(0, root);
        return ans;
    }

    private void dfs(int num, TreeNode treeNode) {
        if (treeNode.right == null && treeNode.left == null) {
            ans += plus(num, treeNode.val);
            return;
        }
        num = plus(num, treeNode.val);
        if (treeNode.left != null) dfs(num, treeNode.left);
        if (treeNode.right != null) dfs(num, treeNode.right);
    }

    private int plus(int num, int nodeV) {
        num <<= 1;
        num += nodeV == 1 ? 1 : 0;
        return num;
    }
}
