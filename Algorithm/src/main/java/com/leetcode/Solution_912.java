package com.leetcode;

public class Solution_912 {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length);
    }

    private int[] mergeSort(int[] nums, int start, int end) {
        if (end - start == 1) return new int[]{nums[start]};
        int mid = (end - start) / 2 + start;
        int[] l = mergeSort(nums, start, mid);
        int[] r = mergeSort(nums, mid, end);
        return merge(l, r);
    }

    private int[] merge(int[] ints1, int[] ints2) {
        int[] tmp = new int[ints1.length + ints2.length];
        int i1 = 0, i2 = 0, t = 0;
        while (i1 < ints1.length && i2 < ints2.length) {
            if (ints1[i1] <= ints2[i2]) {
                tmp[t++] = ints1[i1++];
            } else {
                tmp[t++] = ints2[i2++];
            }
        }
        if (i1 == ints1.length) {
            for (int i = t; i < tmp.length; i++) {
                tmp[i] = ints2[i2++];
            }
        } else {
            for (int i = t; i < tmp.length; i++) {
                tmp[i] = ints1[i1++];
            }
        }
        return tmp;
    }
}
