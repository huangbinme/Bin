package com.study.dfs;

import java.util.LinkedList;
import java.util.List;

public class Solution_3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> sums = new LinkedList<>();
        getSum(root, sums, 0);
        return sums.contains(targetSum);
    }

    private void getSum(TreeNode root, List<Integer> sums, int num) {
        if (root == null) return;
        if (isLeafNode(root)) {
            sums.add(num + root.val);
            return;
        }
        getSum(root.left, sums, num + root.val);
        getSum(root.right, sums, num + root.val);
    }


    private boolean isLeafNode(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }
}
