package com.review;

import java.util.HashMap;
import java.util.Map;

public class Solution_662 {

    long ans = 1;

    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, long[]> map = new HashMap<>();
        dfs(map, root, 0, 0);
        return (int) ans;
    }

    private void dfs(Map<Integer, long[]> map, TreeNode treeNode, int deep, long offset) {
        if (treeNode == null) return;
        if (map.containsKey(deep)) {
            long[] v = map.get(deep);
            v[0] = Math.min(v[0], offset);
            v[1] = Math.max(v[1], offset);
            ans = Math.max(ans, v[1] - v[0] + 1);
        } else {
            map.put(deep, new long[]{offset, offset});
        }
        dfs(map, treeNode.left, deep + 1, offset * 2);
        dfs(map, treeNode.right, deep + 1, offset * 2 + 1);
    }
}
