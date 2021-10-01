package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_437 {
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        map.put(0, 1);
        dfs(root, targetSum, map, preSum);
        return ans;
    }

    private void dfs(TreeNode treeNode, int targetSum, Map<Integer, Integer> map, int preSum) {
        if (treeNode == null) return;
        preSum += treeNode.val;
        ans += map.getOrDefault(preSum - targetSum, 0);
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        dfs(treeNode.left, targetSum, map, preSum);
        dfs(treeNode.right, targetSum, map, preSum);
        map.put(preSum, map.get(preSum) - 1);
    }
}
