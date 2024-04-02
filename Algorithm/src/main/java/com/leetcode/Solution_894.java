package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_894 {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>();
        return dfs(n);
    }

    private List<TreeNode> dfs(int n) {
        if (n == 1) {
            List<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode(0));
            return list;
        }
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i < n - 1; i += 2) {
            List<TreeNode> l = dfs(i);
            List<TreeNode> r = dfs(n - 1 - i);
            for (TreeNode lNode : l) {
                for (TreeNode rNode : r) {
                    TreeNode treeNode = new TreeNode(0);
                    treeNode.left = lNode;
                    treeNode.right = rNode;
                    list.add(treeNode);
                }
            }
        }
        return list;
    }
}