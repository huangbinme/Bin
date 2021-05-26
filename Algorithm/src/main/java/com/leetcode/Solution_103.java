package com.leetcode;

import java.util.*;

public class Solution_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        boolean startFromLeft = true;
        int treeLevelSize = 1;
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            List<Integer> treeList = new ArrayList<>();
            for (int i = 0; i < treeLevelSize; i++) {
                TreeNode listNode;
                if (startFromLeft) {
                    listNode = deque.pollFirst();
                    treeList.add(listNode.val);
                    if (listNode.left != null) deque.offerLast(listNode.left);
                    if (listNode.right != null) deque.offerLast(listNode.right);
                } else {
                    listNode = deque.pollLast();
                    treeList.add(listNode.val);
                    if (listNode.right != null) deque.offerFirst(listNode.right);
                    if (listNode.left != null) deque.offerFirst(listNode.left);
                }
            }
            startFromLeft = !startFromLeft;
            treeLevelSize = deque.size();
            result.add(treeList);
        }
        return result;
    }
}
