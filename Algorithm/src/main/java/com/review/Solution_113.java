package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> save = new ArrayList<>();
        dfs(ans, save, root, targetSum, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> save, TreeNode treeNode, int targetSum, int sum) {
        if (treeNode == null) return;
        save.add(treeNode.val);
        sum += treeNode.val;
        if (targetSum == sum && treeNode.left == null && treeNode.right == null) {
            ans.add(new ArrayList<>(save));
            //此处不能加return，否则没有进行回溯
            //如果加了return需要删除save中的最后一个数字进行回溯
        }
        dfs(ans, save, treeNode.left, targetSum, sum);
        dfs(ans, save, treeNode.right, targetSum, sum);
        save.remove(save.size() - 1);
    }
}
