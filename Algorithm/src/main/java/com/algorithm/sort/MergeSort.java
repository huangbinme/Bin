package com.algorithm.sort;

import java.util.Arrays;

public class MergeSort implements BaseSort{
    @Override
    public int[] sort(int[] input) {
        sort(input, 0, (input.length-1)/2,input.length-1);
         return input;
    }

    public void sort(int[] input,int low,int mid ,int high){
        if(low>=high) return;
        int leftMid = low + (mid-low)/2;
        int rightMid = mid + (high-mid)/2;
        sort(input,low,leftMid,mid);
        sort(input,mid+1,rightMid,high);
        merge(input,low,mid,high);
    }

    public void merge(int[] input,int low,int mid ,int high){
        int[] tmp = Arrays.copyOf(input,input.length);
        int i = low;
        int j = mid+1;

        for (int k = low; k <= high ; k++) {
            if(i>mid){
                input[k] = tmp[j];
                j++;
            }else if(j>high){
                input[k] = tmp[i];
                i++;
            }else if(tmp[i]<tmp[j]){
                input[k] = tmp[i];
                i++;
            }else {
                input[k] = tmp[j];
                j++;
            }
        }
    }
}
