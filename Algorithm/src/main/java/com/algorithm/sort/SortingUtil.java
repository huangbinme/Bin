package com.algorithm.sort;

public class SortingUtil {
    public static void exchange(int[]input, int var1,int var2){
        int tmp = input[var1];
        input[var1] = input[var2];
        input[var2] = tmp;
    }
}
