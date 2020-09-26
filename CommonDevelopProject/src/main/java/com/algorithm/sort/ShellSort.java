package com.algorithm.sort;

public class ShellSort implements BaseSort{
    @Override
    public int[] sort(int[] input){
        int h = input.length/2;
        while(h>=1){
            for (int i = 0; i < h; i++) {
                for (int j = i+h; j < input.length ; j=j+h) {
                    for (int k = j-h; k >=0 ; k=k-h) {
                        if(input[k]>input[k+h]){
                            SortingUtil.exchange(input,k,k+h);
                        }else {
                            break;
                        }
                    }
                }
            }
            h=h/2;
        }
        return input;
    }
}
