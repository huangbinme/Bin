package com.leetcode;

import java.util.PriorityQueue;

public class Solution_99 {
    public void recoverTree(TreeNode root) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        fillQueue(root, queue);
        fillTree(root, queue);
    }

    private void fillTree(TreeNode root, PriorityQueue<Integer> queue) {
        if (root == null) return;
        fillTree(root.left, queue);
        root.val = queue.poll();
        fillTree(root.right, queue);
    }

    private void fillQueue(TreeNode root, PriorityQueue<Integer> queue) {
        if (root == null) return;
        queue.offer(root.val);
        fillQueue(root.left, queue);
        fillQueue(root.right, queue);
    }
}
