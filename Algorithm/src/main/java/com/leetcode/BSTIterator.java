package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    List<Integer> list;
    int index = 0;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        dfs(root);
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) return;
        dfs(treeNode.left);
        list.add(treeNode.val);
        dfs(treeNode.right);
    }

    public int next() {
        return list.get(++index);
    }

    public boolean hasNext() {
        return index + 1 < list.size();
    }
}
