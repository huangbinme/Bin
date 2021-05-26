package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(list1, root1);
        dfs(list2, root2);
        return list1.equals(list2);
    }

    private void dfs(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null) return;
        if (isLeaf(treeNode)) {
            list.add(treeNode.val);
            return;
        }
        dfs(list, treeNode.left);
        dfs(list, treeNode.right);
    }

    private boolean isLeaf(TreeNode treeNode) {
        return treeNode != null && treeNode.left == null && treeNode.right == null;
    }
}
