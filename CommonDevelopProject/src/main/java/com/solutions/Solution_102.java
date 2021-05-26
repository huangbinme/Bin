package com.solutions;

import java.util.*;

public class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            bfs(list, deque);
        }
        return list;
    }

    private void bfs(List<List<Integer>> list, Deque<TreeNode> deque) {
        int size = deque.size();
        List<Integer> integers = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            TreeNode treeNode = deque.pollFirst();
            if (treeNode.left != null) deque.offerLast(treeNode.left);
            if (treeNode.right != null) deque.offerLast(treeNode.right);
            integers.add(treeNode.val);
        }
        list.add(integers);
    }
}
