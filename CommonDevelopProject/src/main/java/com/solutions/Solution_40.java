package com.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, list, candidates, target, 0, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (sum > target || index == candidates.length) return;

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i - 1] == candidates[i]) continue;
            if (sum + candidates[i] > target) break;

            list.add(candidates[i]);
            sum += candidates[i];
            dfs(result, list, candidates, target, i + 1, sum);
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }

}
