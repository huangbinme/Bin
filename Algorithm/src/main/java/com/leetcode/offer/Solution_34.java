package com.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> sub = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, target, sub, 0);
        return ans;
    }

    private void dfs(TreeNode t, List<List<Integer>> ans, int target, List<Integer> sub, int sum) {
        if (t == null) return;
        if (isLeaf(t)) {
            if (sum + t.val == target) {
                List<Integer> list = new ArrayList<>(sub);
                list.add(t.val);
                ans.add(list);
            }
            return;
        }
        sub.add(t.val);
        dfs(t.left, ans, target, sub, sum + t.val);
        dfs(t.right, ans, target, sub, sum + t.val);
        sub.remove(sub.size() - 1);
    }

    private boolean isLeaf(TreeNode t) {
        return t != null && t.left == null && t.right == null;
    }
}
