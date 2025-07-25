package com.review;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_75Test {

    @Test
    public void testSortColors() {
        Solution_75 solution75 = new Solution_75();
        int[] nums = new int[]{2,0,2,1,1,0};
        solution75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}