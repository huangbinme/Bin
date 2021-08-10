package com.leetcode.offer;

public class Solution_39 {
    public int majorityElement(int[] nums) {
        int num = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    count++;
                    num = nums[i];
                } else {
                    count--;
                }
            }
        }
        return num;
    }
}
