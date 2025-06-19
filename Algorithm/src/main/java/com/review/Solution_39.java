package com.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> save = new ArrayList<>();
        dfs(ans, save, target, candidates, 0, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> save, int target, int[] candidates, int sum, int start) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(save));
        }
        for (int i = start; i < candidates.length; i++) {
            save.add(candidates[i]);
            dfs(ans, save, target, candidates, sum + candidates[i], i);
            save.remove(save.size() - 1);
        }
    }
}
