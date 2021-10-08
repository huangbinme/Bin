package com.leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                ans.add(treeNode.val);
                if (treeNode.left != null) deque.offerLast(treeNode.left);
                if (treeNode.right != null) deque.offerLast(treeNode.right);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                sub.add(treeNode.val);
                if (treeNode.left != null) deque.offerLast(treeNode.left);
                if (treeNode.right != null) deque.offerLast(treeNode.right);
            }
            ans.add(sub);
        }
        return ans;
    }
}
