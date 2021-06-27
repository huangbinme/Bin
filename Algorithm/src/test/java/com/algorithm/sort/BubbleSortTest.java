package com.algorithm.sort;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class BubbleSortTest {

    @Test
    public void testSort() {
        BubbleSort sort = new BubbleSort();
        int[] ints = new int[]{5,1,1,2,0,1};
        System.out.println(Arrays.toString(sort.sort(ints)));
    }
}