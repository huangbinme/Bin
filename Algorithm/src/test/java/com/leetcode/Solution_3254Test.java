package com.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution_3254Test {

    @Test
    public void testResultsArray() {
        Solution_3254 solution3254 = new Solution_3254();
        System.out.println(Arrays.toString(solution3254.resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)));
    }
}