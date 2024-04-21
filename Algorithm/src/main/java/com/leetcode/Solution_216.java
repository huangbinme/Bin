package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();
        dfs(ans, subAns, n, k, 0, 1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> subAns, int targetSum, int numCount, int curSum, int start) {
        if (subAns.size() == numCount || curSum > targetSum) {
            if (subAns.size() == numCount & curSum == targetSum) {
                ans.add(new ArrayList<>(subAns));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if(curSum + i > targetSum) break;
            subAns.add(i);
            dfs(ans, subAns, targetSum, numCount, curSum + i, i + 1);
            subAns.remove(subAns.size() - 1);
        }
    }
}
