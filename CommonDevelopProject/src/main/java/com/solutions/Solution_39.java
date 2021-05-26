package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution_39 {
    public List<List<Integer>> combinationSum(int[] ints, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(result, ints, target, list, 0, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] ints, int target, List<Integer> list, int sum, int begin) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < ints.length; i++) {
            list.add(ints[i]);
            dfs(result, ints, target, list, sum + ints[i], i);
            list.remove(list.size() - 1);
        }
    }
}
