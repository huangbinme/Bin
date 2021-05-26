package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution_897 {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        addToList(list, root);
        TreeNode newRoot = list.get(0);
        newRoot.left = null;
        TreeNode tmp = newRoot;
        for (int i = 1; i < list.size(); i++) {
            TreeNode treeNode = list.get(i);
            treeNode.left = null;
            tmp.right = treeNode;
            tmp = tmp.right;
        }
        return newRoot;
    }

    private void addToList(List<TreeNode> list, TreeNode root) {
        if (root == null) return;
        addToList(list, root.left);
        list.add(root);
        addToList(list, root.right);
    }
}
