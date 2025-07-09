package com.review;

public class Solution_189 {
    public void rotate(int[] nums, int k) {
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i], j = (i + k) % nums.length;
            copy[j] = num;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = copy[i];
        }
    }
}
