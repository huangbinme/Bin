package com.study.dfs;

import java.util.*;

public class Solution_11 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permuteResult = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] booleans = new boolean[nums.length];
        dfs(permuteResult, list, booleans, nums);
        return permuteResult;
    }

    private void dfs(List<List<Integer>> permuteResult, List<Integer> list, boolean[] booleans, int[] nums) {
        if (list.size() == booleans.length) {
            permuteResult.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!booleans[i]){
                list.add(nums[i]);
                booleans[i] = true;
                dfs(permuteResult, list, booleans, nums);
                booleans[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
