package com.solutions;

public class Solution_169 {
    public int majorityElement(int[] nums) {
        int m = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == m) {
                count++;
            } else {
                count--;
                if (count == 0 && i != nums.length - 1) {
                    m = nums[i+1];
                    i++;
                    count = 1;
                }
            }
        }
        return m;
    }
}
