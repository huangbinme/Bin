package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null) return;
        if (isLeafNode(treeNode)) {
            list.add(treeNode.val);
            return;
        }
        list.add(treeNode.val);
        dfs(list, treeNode.left);
        dfs(list, treeNode.right);
    }

    private boolean isLeafNode(TreeNode treeNode) {
        return treeNode != null && treeNode.right == null && treeNode.left == null;
    }
}
