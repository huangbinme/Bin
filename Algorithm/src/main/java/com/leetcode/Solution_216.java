package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(ans, k, n, list, 1, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int k, int n, List<Integer> list, int start, int count) {
        if (count > n) return;
        if (list.size() == k) {
            if (count == n) ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfs(ans, k, n, list, i + 1, count + i);
            list.remove(list.size() - 1);
        }
    }
}
