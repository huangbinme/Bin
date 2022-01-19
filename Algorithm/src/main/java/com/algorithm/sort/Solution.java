package com.algorithm.sort;

public class Solution {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end - start <= 1) return;
        int mid = partition(nums, start, end);
        if (mid != start) quickSort(nums, start, mid);
        if (mid != end - 1) quickSort(nums, mid + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int l = start + 1, r = end - 1;
        while (l < r) {
            if (nums[l] > nums[start]) {
                swap(nums, l, r--);
                continue;
            }
            l++;
        }
        if (nums[l] > nums[start]) {
            swap(nums, start, l - 1);
            return l - 1;
        } else {
            swap(nums, start, l);
            return l;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
