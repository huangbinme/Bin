package com.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        List<Integer> list = new ArrayList<>();
        dfs(result, list, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            dfs(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }


}
