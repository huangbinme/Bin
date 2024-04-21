package com.leetcode;

import java.util.*;

public class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(candidates, ans, sub, target, 0, 0);
        return ans;
    }

    private void dfs(int[] candidates, List<List<Integer>> ans, List<Integer> sub, int target, int sum, int start) {
        if (sum >= target) {
            if (sum == target) ans.add(new ArrayList<>(sub));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            sub.add(candidates[i]);
            dfs(candidates, ans, sub, target, sum + candidates[i], i);
            sub.remove(sub.size() - 1);
        }
    }
}
