package com.leetcode;

public class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return notExist();
        if (nums.length == 1) {
            if (nums[0] == target) return new int[]{0, 0};
            if (nums[0] != target) return notExist();
        }

        int left = 0;
        int right = nums.length - 1;
        while (left + 1 != right) {
            int mid = getMid(left, right);
            if (nums[left] <= target && target <= nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] != target && nums[right] != target) return notExist();
        return extendSearch(nums, left, right, target);
    }

    private int[] extendSearch(int[] nums, int left, int right, int target) {
        int start;
        if (nums[left] == target) {
            start = left;
        } else {
            start = right;
        }
        int left_result = start;
        while (left_result - 1 >= 0 && nums[left_result - 1] == target) {
            left_result--;
        }

        int right_result = start;
        while (right_result + 1 < nums.length && nums[right_result + 1] == target) {
            right_result++;
        }
        return new int[]{left_result, right_result};
    }

    private int[] notExist() {
        return new int[]{-1, -1};
    }

    private int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
