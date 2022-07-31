package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_1161 {
    public int maxLevelSum(TreeNode root) {
        int maxInLayer = Integer.MIN_VALUE, ans = 1;
        Deque<TreeNode> deque = new LinkedList<>();
        int layer = 1, size = 1;
        deque.add(root);
        while (!deque.isEmpty()) {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode n = deque.pollFirst();
                if (n.left != null) deque.offerLast(n.left);
                if (n.right != null) deque.offerLast(n.right);
                sum += n.val;
            }
            if (sum > maxInLayer) {
                maxInLayer = sum;
                ans = layer;
            }
            layer++;
            size = deque.size();
        }
        return ans;
    }
}
