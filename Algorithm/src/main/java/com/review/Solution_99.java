package com.review;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution_99 {

    int i = 0;

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, false);
        list.sort(Comparator.naturalOrder());
        dfs(root, list, true);
    }

    private void dfs(TreeNode root, List<Integer> list, boolean setV) {
        if (root == null) return;
        dfs(root.left, list, setV);
        if (setV) {
            root.val = list.get(i++);
        } else {
            list.add(root.val);
        }
        dfs(root.right, list, setV);
    }
}
