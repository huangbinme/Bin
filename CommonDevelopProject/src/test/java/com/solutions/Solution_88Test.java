package com.solutions;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution_88Test {

    @Test
    public void testMerge() {
        Solution_88 solution_88 = new Solution_88();
        int[] ints = new int[]{0};
        int[] ints2 = new int[]{1};
        solution_88.merge2(ints,0,ints2,1);
        System.out.println(Arrays.toString(ints));
    }
}