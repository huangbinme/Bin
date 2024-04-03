package com.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Solution_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        boolean[] note = new boolean[nums.length];
        dfs(ans, sub, note, nums);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> sub, boolean[] note, int[] nums) {
        if (sub.size() == nums.length) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (note[i]) continue;
            note[i] = true;
            sub.add(nums[i]);
            dfs(ans, sub, note, nums);
            note[i] = false;
            sub.remove(sub.size() - 1);
        }
    }
}
