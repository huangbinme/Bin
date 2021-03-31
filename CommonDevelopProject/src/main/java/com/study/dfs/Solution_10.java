package com.study.dfs;

import java.util.HashMap;
import java.util.Map;

public class Solution_10 {
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        initMap(inorder);
        return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode build(int[] inorder, int inorder_start, int inorder_end, int[] postorder, int postorder_start, int postorder_end) {
        if (inorder_start == inorder_end) {
            return null;
        }

        TreeNode treeNode = new TreeNode(postorder[postorder_end - 1]);
        int rootIndex = inorderMap.get(treeNode.val);
        treeNode.left = build(inorder, inorder_start, rootIndex, postorder, postorder_start, postorder_start + rootIndex - inorder_start);
        treeNode.right = build(inorder, rootIndex + 1, inorder_end, postorder, postorder_start + rootIndex - inorder_start, postorder_end - 1);
        return treeNode;
    }

    private void initMap(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
    }
}
