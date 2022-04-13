package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(list, root);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode t = list.get(i);
            t.left = null;
            t.right = list.get(i + 1);
        }
    }

    private void dfs(List<TreeNode> list, TreeNode root) {
        if (root == null) return;
        list.add(root);
        dfs(list, root.left);
        dfs(list, root.right);
    }
}
