package com.review;

public class Solution_129 {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return ans;
    }

    private void dfs(TreeNode treeNode, StringBuilder sb) {
        if (treeNode == null) return;
        sb.append(treeNode.val);
        if (treeNode.right == null && treeNode.left == null) {
            ans += Integer.parseInt(sb.toString());
        }
        dfs(treeNode.left, sb);
        dfs(treeNode.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
