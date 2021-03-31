package com.study.dfs;

public class Solution_2 {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return traverseTree(root);
    }

    public int traverseTree(TreeNode treeNode) {
        if (isLeafNode(treeNode)) return 1;

        if(treeNode.left==null){
            return traverseTree(treeNode.right)+1;
        }

        if(treeNode.right==null){
            return traverseTree(treeNode.left)+1;
        }

        return Math.min(traverseTree(treeNode.left)+1,traverseTree(treeNode.right)+1);
    }

    private boolean isLeafNode(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }
}
