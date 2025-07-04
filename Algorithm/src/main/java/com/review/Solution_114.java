package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    private void dfs(TreeNode treeNode, List<TreeNode> list) {
        if (treeNode == null) return;
        list.add(treeNode);
        dfs(treeNode.left, list);
        dfs(treeNode.right, list);
    }
}
