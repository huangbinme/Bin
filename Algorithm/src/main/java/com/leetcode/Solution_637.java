package com.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode n = deque.pollFirst();
                sum += (long) n.val;
                if (n.left != null) deque.offerLast(n.left);
                if (n.right != null) deque.offerLast(n.right);
            }
            ans.add((double) sum / size);
        }
        return ans;
    }
}
