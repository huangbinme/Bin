package com.solutions;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        dfs(result, deque, used, 0, nums.length, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, Deque<Integer> deque, boolean[] used, int index, int count, int[] nums) {
        if (index == count) {
            result.add(new LinkedList<>(deque));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                deque.offerLast(nums[i]);
                used[i] = true;
                dfs(result, deque, used, index+1, count, nums);
                deque.pollLast();
                used[i] = false;
            }
        }
    }
}
