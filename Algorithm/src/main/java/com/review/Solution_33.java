package com.review;

public class Solution_33 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid] && nums[l] <= target && target <= nums[mid]) {
                r = mid;
            } else if (nums[mid + 1] <= nums[l] && !(nums[mid + 1] <= target && target <= nums[r])) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
