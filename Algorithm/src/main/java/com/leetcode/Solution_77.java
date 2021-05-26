package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(result, list, n, k, 1);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
