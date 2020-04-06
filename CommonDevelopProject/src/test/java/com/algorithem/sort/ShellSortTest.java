package com.algorithem.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ShellSortTest {

    @Test
    public void sort() {
        int [] input = CommonUtil.getRandomIntAraryByLength(5);
        int [] sortResult = ShellSort.sort(input.clone());
        Arrays.sort(input);
        Assert.assertArrayEquals(input,sortResult);
    }
}