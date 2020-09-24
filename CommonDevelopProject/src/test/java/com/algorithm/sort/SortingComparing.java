package com.algorithm.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingComparing {
    protected final static Logger LOGGER = LogManager.getLogger();

    @Test
    public void sort() {
        int sortingArrayLength = 50000;
        int[] input = CommonUtil.getRandomIntArrayByLength(sortingArrayLength);
        LOGGER.info("Input array length [{}]",sortingArrayLength);
        List<BaseSort> baseSortList = new ArrayList<>();
        baseSortList.add(new ShellSort());
        baseSortList.add(new BubbleSort());
        baseSortList.stream().forEach(baseSort -> CommonUtil.sortThenPrintTime(baseSort, Arrays.copyOf(input,input.length)));
    }
}
