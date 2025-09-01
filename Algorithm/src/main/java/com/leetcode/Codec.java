package com.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        Deque<String> deque = new LinkedList<>(Arrays.asList(strings));
        return dfs(deque);
    }

    private TreeNode dfs(Deque<String> deque) {
        String s = deque.pollFirst();
        if (s.equals("N")) return null;
        TreeNode treeNode = new TreeNode(Integer.parseInt(s));
        treeNode.left = dfs(deque);
        treeNode.right = dfs(deque);
        return treeNode;
    }
}
