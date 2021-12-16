package com.leetcode.offer;

public class Solution_26 {
    boolean ans = false;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        dfs(A, B);
        return ans;
    }

    private void dfs(TreeNode a, TreeNode b) {
        if (a == null || ans) return;
        if (a.val == b.val && compare(a, b)) {
            ans = true;
        } else {
            dfs(a.left, b);
            dfs(a.right, b);
        }
    }

    private boolean compare(TreeNode a, TreeNode b) {
        if (a == null || b == null) return b == null;
        if (a.val != b.val) return false;
        return compare(a.right, b.right) && compare(a.left, b.left);
    }
}
