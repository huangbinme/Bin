package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_95 {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        if (start == end) {
            return Collections.singletonList(new TreeNode(start));
        }
        if (start > end) return null;
        List<TreeNode> ans = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dfs(start, i - 1);
            List<TreeNode> right = dfs(i + 1, end);
            if (left == null) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.right = right.get(k);
                    ans.add(root);
                }
            } else if (right == null) {
                for (int k = 0; k < left.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(k);
                    ans.add(root);
                }
            } else {
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        TreeNode root = new TreeNode(i);
                        root.left = left.get(j);
                        root.right = right.get(k);
                        ans.add(root);
                    }
                }
            }
        }
        return ans;
    }
}
