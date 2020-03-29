package com.algorithem.sort;

public class ShellSort {
    public static int[] sort(int[] input){
        int increment = input.length;
        while(true){
            increment = increment/2;
            for (int i=0;i<increment;i++) {
                for(int j=i;j<input.length;j+=increment){
                    int location=j;
                    while(location>i&&input[location-increment]>input[location]){
                        int tmp = input[location];
                        input[location] = input[location-increment];
                        input[location-increment] = tmp;
                        location-=increment;
                    }
                }
            }
            if(increment<1){
                break;
            }
        }
        return input;
    }
}
