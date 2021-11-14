package com.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution_7 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pre_from, int pre_to, int[] inorder, int in_from, int in_to) {
        TreeNode t = new TreeNode(preorder[pre_from]);
        int index = map.get(preorder[pre_from]);
        t.left = index == in_from ? null : build(preorder, pre_from + 1, pre_from + index - in_from, inorder, in_from, index - 1);
        t.right = index == in_to ? null : build(preorder, pre_from + index - in_from + 1, pre_to, inorder, index + 1, in_to);
        return t;
    }
}
