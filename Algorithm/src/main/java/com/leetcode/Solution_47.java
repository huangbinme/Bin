package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] booleans = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(result, list, nums, booleans);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] booleans) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (booleans[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !booleans[i - 1]) continue;
            list.add(nums[i]);
            booleans[i] = true;
            dfs(result, list, nums, booleans);
            list.remove(list.size() - 1);
            booleans[i] = false;
        }
    }
}
