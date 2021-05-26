package com.algorithm.sort;

public class BubbleSort implements BaseSort {

    @Override
    public int[] sort(int[] input) {
        boolean ifBreak = true;
        int j = input.length - 1;
        while (ifBreak) {
            ifBreak = false;
            for (int i = 0; i < j; i++) {
                if (input[i] > input[i + 1]) {
                    SortingUtil.exchange(input, i, i + 1);
                    ifBreak = true;
                }
            }
            j--;
        }
        return input;
    }

}
