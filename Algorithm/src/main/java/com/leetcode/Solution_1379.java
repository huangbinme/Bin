package com.leetcode;

public class Solution_1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original, cloned, target);
    }

    private TreeNode dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        if (cloned == null) return null;
        if (original == target) return cloned;
        TreeNode l = dfs(original.left, cloned.left, target);
        if (l != null) return l;
        return dfs(original.right, cloned.right, target);
    }
}
