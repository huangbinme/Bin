package com.leetcode;

public class Solution_1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(preorder[start]);

        TreeNode treeNode = new TreeNode(preorder[start]);
        int mid = getRightTreeIndex(preorder, treeNode.val, start, end);
        treeNode.left = dfs(preorder, start + 1, mid - 1);
        treeNode.right = dfs(preorder, mid, end);
        return treeNode;
    }

    private int getRightTreeIndex(int[] ints, int root, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (ints[i] > root) return i;
        }
        return end + 1;
    }
}
