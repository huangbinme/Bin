package com.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> save = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans, save, nums, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> save, int[] nums, int start) {
        ans.add(new ArrayList<>(save));
        if (start >= nums.length) return;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            save.add(nums[i]);
            dfs(ans, save, nums, i + 1);
            save.remove(save.size() - 1);
        }
    }
}
