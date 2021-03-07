package com.solutions;

import java.util.*;

public class Solution_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        find(result, nums);
        return result;
    }

    private void find(List<List<Integer>> result, int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int targetNum = nums[i] * -1;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int add = nums[left] + nums[right];
                if (add == targetNum) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int tmp = nums[left];
                    while (left<nums.length&&nums[left] == tmp) left++;
                } else if (add - targetNum > 0) {
                    int tmp = nums[right];
                    while (nums[right] == tmp) right--;
                } else {
                    int tmp = nums[left];
                    while (left<nums.length&&nums[left] == tmp) left++;
                }
            }
        }
    }
}
