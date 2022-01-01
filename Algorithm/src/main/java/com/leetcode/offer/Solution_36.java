package com.leetcode.offer;

public class Solution_36 {
    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (head == null) head = cur;
        if (pre != null) {
            cur.left = pre;
            pre.right = cur;
        }
        pre = cur;
        dfs(cur.right);
    }
}
