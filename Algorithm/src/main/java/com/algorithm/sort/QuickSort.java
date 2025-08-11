package com.algorithm.sort;

public class QuickSort implements BaseSort {
    @Override
    public int[] sort(int[] input) {
        sort(input, 0, input.length - 1);
        return input;
    }

    public void sort(int[] input, int low, int high) {
        if (low < high) {
            int pivot = partition(input, low, high);
            sort(input, low, pivot - 1);
            sort(input, pivot + 1, high);
        }
    }

    private int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int l = low, r = high - 1;
        while (l <= r) {
            while (l <= r && input[l] <= pivot) l++;
            while (l <= r && pivot <= input[r]) r--;
            if (l < r) swap(input, l, r);
        }
        swap(input, l, high);
        return l;
    }

    private void swap(int[] input, int l, int r) {
        int t = input[l];
        input[l] = input[r];
        input[r] = t;
    }
}
