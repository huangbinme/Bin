package com.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = deque.pollFirst();
                sub.add(t.val);
                if(t.left != null) deque.offerLast(t.left);
                if(t.right != null) deque.offerLast(t.right);
            }
            ans.add(sub);
        }
        return ans;
    }
}
