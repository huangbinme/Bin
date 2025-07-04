package com.review;

import java.util.*;

public class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        boolean fromLeftToRight = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                sub.add(treeNode.val);
                if (treeNode.left != null) deque.offerLast(treeNode.left);
                if (treeNode.right != null) deque.offerLast(treeNode.right);
            }
            if (!fromLeftToRight) Collections.reverse(sub);
            fromLeftToRight = !fromLeftToRight;
            ans.add(sub);
        }
        return ans;
    }
}
