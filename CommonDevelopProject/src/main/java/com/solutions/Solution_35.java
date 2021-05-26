package com.solutions;

public class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) return 0;
        if (nums[nums.length - 1] <= target) return nums[nums.length - 1] == target ? nums.length - 1 : nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 != right) {
            int mid = getMid(left, right);
            if (nums[mid] >= target && target >= nums[left]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) return left;
        return right;
    }

    private int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
