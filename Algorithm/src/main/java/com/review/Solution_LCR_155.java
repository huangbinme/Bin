package com.review;

public class Solution_LCR_155 {
    TreeNode head, pre;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        if (head != pre) {
            head.left = pre;
            pre.right = head;
        }
        return head;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (head == null) head = node;
        node.left = pre;
        if (pre != null) pre.right = node;
        pre = node;
        dfs(node.right);
    }
}
