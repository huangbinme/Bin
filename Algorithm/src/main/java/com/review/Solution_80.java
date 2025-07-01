package com.review;

public class Solution_80 {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (slow >= 2 && nums[slow - 2] == nums[fast]) {
                fast++;
            } else {
                int t = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = t;
                slow++;
                fast++;
            }
        }
        return slow;
    }
}
