package com.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(ans, list, root, targetSum, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> list, TreeNode treeNode, int targetSum, int nodeSum) {
        if (isLeafNode(treeNode)) {
            list.add(treeNode.val);
            if (nodeSum + treeNode.val == targetSum) ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(treeNode.val);
        if (treeNode.left != null) dfs(ans, list, treeNode.left, targetSum, nodeSum + treeNode.val);
        if (treeNode.right != null) dfs(ans, list, treeNode.right, targetSum, nodeSum + treeNode.val);
        list.remove(list.size() - 1);
    }

    private boolean isLeafNode(TreeNode treeNode) {
        return treeNode != null && treeNode.left == null && treeNode.right == null;
    }
}
