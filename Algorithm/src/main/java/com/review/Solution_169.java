package com.review;

public class Solution_169 {
    public int majorityElement(int[] nums) {
        int num = -1, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
                count = 1;
            } else {
                if (num == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return num;
    }
}
