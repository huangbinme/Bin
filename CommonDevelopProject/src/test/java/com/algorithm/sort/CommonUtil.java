package com.algorithm.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.Arrays;

public class CommonUtil {
    protected final static Logger LOGGER = LogManager.getLogger();

    public static int[] getRandomIntArrayWithUnique(int length){
        int [] result = new int[length];
        for(int i=0 ; i<length ; i++){
            result[i] = i;
        }
        for (int i = length-1; i >=0 ; i--) {
            int relocationIndex = CommonUtil.getRandomInt(i);
            int relocationNum = result[relocationIndex];
            result[relocationIndex] = result[i];
            result[i] = relocationNum;
        }
        return result;
    }

    public static int[] getRandomIntArray(int length){
        int [] result = new int[length];
        for(int i=0 ; i<length ; i++){
            result[i] = CommonUtil.getRandomInt(length);
        }
        return result;
    }

    public static int getRandomInt(int maxInt){
        return (int)(Math.random()*maxInt);
    }

    public static void sortThenPrintTime(BaseSort baseSort,int[] input){
        int[] beforeSorting = Arrays.copyOf(input,input.length);
        Long start = System.currentTimeMillis();
        int[] afterSorting = baseSort.sort(input);
        Double sortingTime = (System.currentTimeMillis()-start)/1000D;
        Assert.assertArrayEquals(CommonUtil.sortArrayWithoutClone(beforeSorting),afterSorting);
        LOGGER.info("Sorting algorithm implement [{}], sorting time [{}] seconds",baseSort.getClass().getName(),sortingTime);
    }

    public static int[] sortArrayWithoutClone(int[] input){
        Arrays.sort(input);
        return input;
    }
}
