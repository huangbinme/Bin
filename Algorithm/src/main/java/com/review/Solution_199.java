package com.review;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ans.add(deque.peekLast().val);
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                if(treeNode.left != null) deque.offerLast(treeNode.left);
                if(treeNode.right != null) deque.offerLast(treeNode.right);
            }
        }
        return ans;
    }
}
