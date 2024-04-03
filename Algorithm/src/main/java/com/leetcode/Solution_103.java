package com.leetcode;

import java.util.*;

public class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                if (treeNode.left != null) deque.offerLast(treeNode.left);
                if (treeNode.right != null) deque.offerLast(treeNode.right);
                sub.add(treeNode.val);
            }
            ans.add(sub);
        }
        for (int i = 1; i < ans.size(); i += 2) {
            Collections.reverse(ans.get(i));
        }
        return ans;
    }
}
