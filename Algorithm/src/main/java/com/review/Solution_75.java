package com.review;

public class Solution_75 {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) l++;
            if (nums[i] == 2) r--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < l) {
                nums[i] = 0;
            } else if (i >= l && i <= r) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
