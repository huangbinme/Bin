package com.review;

import java.util.Random;

public class Solution_912 {

    Random random = new Random();

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        int pivot = partition(nums, start, end);
        if (start < pivot - 1) quickSort(nums, start, pivot - 1);
        if (pivot + 1 < end) quickSort(nums, pivot + 1, end);

    }

    private int partition(int[] nums, int start, int end) {
        int pivot = random.nextInt(end - start + 1) + start;
        swap(nums, start, pivot);
        int l = start + 1, r = end;
        while (l <= r) {
            while (l <= r && nums[r] >= nums[start]) r--;
            while (l <= r && nums[l] <= nums[start]) l++;
            if (l > r) break;
            swap(nums, l, r);
        }
        swap(nums, start, r);
        return r;
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
