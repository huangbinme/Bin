package com.study.dfs;

import java.util.HashMap;
import java.util.Map;

public class Solution_9 {

    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        initMap(inorder);
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int pre_left, int pre_right, int[] inorder, int in_left, int in_right) {
        if (in_right - in_left <= 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[pre_left]);
        int index = inorderMap.get(treeNode.val);
        int leftCount = index - in_left;
        treeNode.left = build(preorder, pre_left + 1, pre_left + 1 + leftCount, inorder, in_left, index);
        treeNode.right = build(preorder, pre_left + 1 + leftCount, pre_right, inorder, index + 1, in_right);
        return treeNode;
    }

    private void initMap(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
    }
}
