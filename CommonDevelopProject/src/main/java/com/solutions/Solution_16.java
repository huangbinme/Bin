package com.solutions;

import java.util.Arrays;

public class Solution_16 {
    public int threeSumClosest(int[] nums, int target) {
        int closestNum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == target) return target;
                closestNum = Math.abs(closestNum - target) > Math.abs(nums[i] + nums[left] + nums[right] - target) ? nums[i] + nums[left] + nums[right] : closestNum;
                if (nums[i] + nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return closestNum;
    }
}
