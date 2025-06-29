package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> save = new ArrayList<>();
        dfs(ans, save, 1, n, k);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> save, int num, int maxM, int k) {
        if (save.size() == k) {
            ans.add(new ArrayList<>(save));
            return;
        }
        for (int i = num; i <= maxM; i++) {
            save.add(i);
            dfs(ans, save, i+1, maxM, k);
            save.remove(save.size() - 1);
        }
    }
}
