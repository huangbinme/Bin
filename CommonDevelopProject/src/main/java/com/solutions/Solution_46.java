package com.solutions;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(result, list, used, 0, nums.length, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, boolean[] used, int index, int count, int[] nums) {
        if (index == count) {
            result.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                dfs(result, list, used, index + 1, count, nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}
