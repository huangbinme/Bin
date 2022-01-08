package com.leetcode.offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Solution_37 {
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        StringBuilder sb = new StringBuilder();
        while (!bfs.isEmpty()) {
            TreeNode t = bfs.pollFirst();
            if (t == null) {
                sb.append("N|");
            } else {
                sb.append(t.val).append("|");
                bfs.offerLast(t.left);
                bfs.offerLast(t.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Deque<Integer> integers = Arrays.stream(data.split("\\|"))
                .map(s -> "N".equals(s) ? null : Integer.parseInt(s))
                .collect(Collectors.toCollection(LinkedList::new));
        TreeNode treeNode = new TreeNode(integers.pollFirst());
        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(treeNode);
        while (!treeNodes.isEmpty()) {
            TreeNode t = treeNodes.pollFirst();
            Integer l = integers.pollFirst();
            t.left = l == null ? null : new TreeNode(l);
            Integer r = integers.pollFirst();
            t.right = r == null ? null : new TreeNode(r);
            if (t.left != null) treeNodes.offer(t.left);
            if (t.right != null) treeNodes.offer(t.right);
        }
        return treeNode;
    }
}
