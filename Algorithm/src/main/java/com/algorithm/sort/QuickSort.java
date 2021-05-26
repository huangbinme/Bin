package com.algorithm.sort;

public class QuickSort implements BaseSort{
    @Override
    public int[] sort(int[] input) {
        sort(input, 0, input.length-1);
        return input;
    }

    public void sort(int[] input, int low, int high){
        if(low>=high) return;
        int partitionLocation = partition(input,low,high);
        sort(input,low,partitionLocation);
        sort(input,partitionLocation+1,high);
    }

    private int partition(int[] input, int low, int high) {
        int partitionIndex = low;
        for (int i = low+1; i <= high; i++) {
            if(input[i]<input[partitionIndex]){
                for (int j = i; j > partitionIndex; j--) {
                    SortingUtil.exchange(input,j,j-1);
                }
                partitionIndex++;
            }
        }
        return partitionIndex;
    }
}
