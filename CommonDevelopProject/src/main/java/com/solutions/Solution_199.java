package com.solutions;

import java.util.*;

public class Solution_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        int levelSize = 1;
        while (!deque.isEmpty()) {
            list.add(deque.peekLast().val);
            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = deque.pollFirst();
                if (treeNode.left != null) deque.offerLast(treeNode.left);
                if (treeNode.right != null) deque.offerLast(treeNode.right);
            }
            levelSize = deque.size();
        }
        return list;
    }
}
