package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_589 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    private void dfs(List<Integer> ans, Node root) {
        if(root == null) return;
        ans.add(root.val);
        for (Node child : root.children) {
            dfs(ans, child);
        }
    }
}
