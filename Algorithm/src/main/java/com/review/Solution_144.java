package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    private void dfs(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        dfs(ans, root.left);
        dfs(ans, root.right);
    }
}
