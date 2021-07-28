package com.leetcode;

import java.util.*;

public class Solution_863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (root.right != null) list.add(root.right.val);
        if (root.left != null) list.add(root.left.val);
        map.put(root.val, list);
        traverse(root.left, root, map);
        traverse(root.right, root, map);
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Boolean> boolMap = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            boolMap.put(entry.getKey(), false);
        }
        bfs(map, ans, boolMap, target.val, k);
        return ans;
    }

    private void bfs(Map<Integer, List<Integer>> map, List<Integer> ans, Map<Integer, Boolean> boolMap, int target, int k) {
        Deque<Integer> list = new LinkedList<>();
        list.add(target);
        boolMap.put(target, true);
        for (int i = 0; i < k; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                if (list.isEmpty()) return;
                int num = list.pollFirst();
                List<Integer> sub = map.get(num);
                for (int l = 0; l < sub.size(); l++) {
                    int numInSub = sub.get(l);
                    if (!boolMap.get(numInSub)) {
                        list.offerLast(numInSub);
                        boolMap.put(numInSub, true);
                    }
                }
            }
        }
        ans.addAll(list);
    }

    private void traverse(TreeNode treeNode, TreeNode parent, Map<Integer, List<Integer>> map) {
        if (treeNode == null) return;
        List<Integer> list = map.getOrDefault(treeNode.val, new LinkedList<>());
        list.add(parent.val);
        if (treeNode.right != null) list.add(treeNode.right.val);
        if (treeNode.left != null) list.add(treeNode.left.val);
        map.put(treeNode.val, list);
        traverse(treeNode.right, treeNode, map);
        traverse(treeNode.left, treeNode, map);
    }
}
