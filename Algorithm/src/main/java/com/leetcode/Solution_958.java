package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_958 {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        boolean preHasNull = false;
        while (!deque.isEmpty()) {
            TreeNode t = deque.pollFirst();
            if (t == null) {
                preHasNull = true;
            } else {
                if (preHasNull) return false;
                deque.offerLast(t.left);
                deque.offerLast(t.right);
            }
        }
        return true;
    }
}
