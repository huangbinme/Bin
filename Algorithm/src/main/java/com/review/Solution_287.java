package com.review;

public class Solution_287 {
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int lCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (l <= nums[i] && nums[i] <= mid) lCount++;
            }
            if (lCount > mid - l + 1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
