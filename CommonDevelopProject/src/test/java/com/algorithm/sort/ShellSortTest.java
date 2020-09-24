package com.algorithm.sort;

import org.junit.Test;

public class ShellSortTest {

    @Test
    public void testBubbleSort() {
        int [] input = CommonUtil.getRandomIntArrayByLength(30000);
        BaseSort baseSort = new BubbleSort();
        CommonUtil.sortThenPrintTime(baseSort,input);
    }
}