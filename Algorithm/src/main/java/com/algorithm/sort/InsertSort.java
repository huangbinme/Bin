package com.algorithm.sort;

public class InsertSort implements BaseSort {
    @Override
    public int[] sort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (input[j] > input[j + 1]) {
                    SortingUtil.exchange(input, j, j + 1);
                } else {
                    break;
                }
            }
        }
        return input;
    }


    /**
     * This method might lead to error of StackOverflowError
     **/
    public void recursion(int[] input, int iterateIndex) {
        if (iterateIndex > input.length - 1) {
            return;
        }
        if (iterateIndex == 0) {
            recursion(input, iterateIndex + 1);
        }
        for (int i = iterateIndex - 1; i >= 0; i--) {
            if (input[i] > input[i + 1]) {
                SortingUtil.exchange(input, i, i + 1);
            } else {
                break;
            }
        }
        recursion(input, iterateIndex + 1);
    }
}
