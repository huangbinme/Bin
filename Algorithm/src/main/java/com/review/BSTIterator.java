package com.review;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    List<Integer> list = new ArrayList<>();

    int i = 0;

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public int next() {
        return list.get(i++);
    }

    public boolean hasNext() {
        return i < list.size();
    }
}
