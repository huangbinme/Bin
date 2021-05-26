package com.algorithm.sort;

public class SelectSort implements BaseSort {
    @Override
    public int[] sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            int minNum = input[i];
            for (int j = i; j < input.length; j++) {
                if (input[j] < minNum) {
                    minIndex = j;
                    minNum = input[j];
                }
            }
            SortingUtil.exchange(input, i, minIndex);
        }
        return input;
    }
}
