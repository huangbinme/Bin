package com.leetcode.offer;

import java.util.Arrays;

public class Solution_40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        init(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            buildMinHeap(arr, 0, i);
            if (i + k == arr.length) break;
        }
        return Arrays.copyOfRange(arr, arr.length - k, arr.length);
    }

    private void init(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            buildMinHeap(arr, i, arr.length);
        }
    }

    private void buildMinHeap(int[] arr, int start, int size) {
        int r = start * 2 + 1, l = r + 1;
        int min = start;
        if (r < size && arr[min] > arr[r]) {
            min = r;
        }
        if (l < size && arr[min] > arr[l]) {
            min = l;
        }
        if (min != start) {
            swap(arr, min, start);
            buildMinHeap(arr, min, size);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
