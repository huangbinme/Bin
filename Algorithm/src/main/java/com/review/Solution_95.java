package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_95 {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int min, int max) {
        List<TreeNode> list = new ArrayList<>();
        if (min >= max) {
            list.add(max == min ? new TreeNode(max) : null);
            return list;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> leftList = dfs(min, i - 1);
            List<TreeNode> rightList = dfs(i + 1, max);
            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftList.get(j);
                    treeNode.right = rightList.get(k);
                    list.add(treeNode);
                }
            }
        }
        return list;
    }
}
