package com.study.dfs;

public class Solution_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return traverseTree(root,0);
    }

    public int traverseTree(TreeNode treeNode, int i){
        if(treeNode==null) return i;
        return Math.max(traverseTree(treeNode.left,i+1), traverseTree(treeNode.right,i+1));
    }
}
