package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> save = new ArrayList<>();
        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        dfs(ans, save, nums, 0, 0, k, n);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> save, int[] nums, int start, int curSum, int k, int n) {
        if (save.size() == k) {
            if (curSum == n) ans.add(new ArrayList<>(save));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (curSum + nums[i] > n) break;
            save.add(nums[i]);
            dfs(ans, save, nums, i + 1, curSum + nums[i], k, n);
            save.remove(save.size() - 1);
        }
    }
}
