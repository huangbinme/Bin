package com.sort;

public class CommonUtil {
    public static int[] getRandomIntAraryByLength(int length){
        int [] result = new int[length];
        for(int i=0;i<length;i++){
            int num = (int)(Math.random()*10000);
            result[i] = num;
        }
        return result;
    }
}
