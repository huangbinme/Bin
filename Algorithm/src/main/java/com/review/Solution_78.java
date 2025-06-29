package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> save = new ArrayList<>();
        dfs(ans, save, nums, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> save, int[] nums, int start) {
        ans.add(new ArrayList<>(save));
        for (int i = start; i < nums.length; i++) {
            save.add(nums[i]);
            dfs(ans, save, nums, i + 1);
            save.remove(save.size() - 1);
        }
    }
}
