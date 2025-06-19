package com.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> save = new ArrayList<>();
        dfs(ans, save, used, nums);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> save, boolean[] used, int[] nums) {
        if (save.size() == nums.length) {
            ans.add(new ArrayList<>(save));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            save.add(nums[i]);
            used[i] = true;
            dfs(ans, save, used, nums);
            save.remove(save.size() - 1);
            used[i] = false;
        }
    }
}
