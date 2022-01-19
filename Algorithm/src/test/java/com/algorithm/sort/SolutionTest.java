package com.algorithm.sort;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class SolutionTest {

    @Test
    public void testSort() {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{2,1})));
    }
}