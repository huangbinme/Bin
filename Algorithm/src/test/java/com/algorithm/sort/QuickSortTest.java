package com.algorithm.sort;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void testSort() {
        int[] arr1 = {};
        validate(arr1);
        int[] arr2 = {42};
        validate(arr2);
        int[] arr3 = {5, 5};
        validate(arr3);
        int[] arr4 = {9, 2};
        validate(arr4);

        int[] arr5 = {3, 1, 4, 1, 5, 9, 2};  // 含重复数字的乱序数组
        validate(arr5);
        int[] arr6 = {1, 2, 3, 4, 5};        // 已经有序
        validate(arr6);
        int[] arr7 = {5, 4, 3, 2, 1};        // 逆序
        validate(arr7);

        int[] arr8 = {7, 7, 7, 7, 7};        // 所有元素相同
        validate(arr8);
        int[] arr9 = {-3, 0, 2, -5, 8};      // 包含负数
        validate(arr9);
        int[] arr10 = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE}; // 极大/极小值
        validate(arr10);

        int[] arr11 = new int[1000];        // 长度为 1000 的全 0 数组（相同元素）
        validate(arr11);
        int[] arr12 = new int[1000];        // 长度为 1000 的递减数组（最坏情况）
        for (int i = 0; i < arr12.length; i++) {
            arr12[i] = 1000 - i;
        }
        validate(arr12);
    }

    public void validate(int[] input) {
        int[] copy = Arrays.copyOf(input, input.length);
        Arrays.sort(copy);
        QuickSort quickSort = new QuickSort();
        int[] afterSort = quickSort.sort(input);
        Assert.assertTrue(Arrays.equals(copy, afterSort));
    }
}