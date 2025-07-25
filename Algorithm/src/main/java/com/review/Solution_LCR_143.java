package com.review;

public class Solution_LCR_143 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return (A.val == B.val && dfs(A, B)) || isSubStructure(A.right, B) || isSubStructure(A.left, B);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        if (a.val != b.val) return false;
        return dfs(a.left, b.left) && dfs(a.right, b.right);
    }
}
