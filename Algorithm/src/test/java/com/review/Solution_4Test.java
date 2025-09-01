package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_4Test {

    @Test
    public void testFindMedianSortedArrays() {
        Solution_4 solution4 = new Solution_4();
        System.out.println(solution4.findMedianSortedArrays(new int[]{1,3},new int[]{2}));
    }
}