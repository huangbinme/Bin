package com.review;

import com.leetcode.Solution_159;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_lcr_159Test {

    @Test
    public void testInventoryManagement() {
        Solution_lcr_159 solutionLcr159 = new Solution_lcr_159();
        int[] ints = solutionLcr159.inventoryManagement(new int[]{0,2,3,6}, 2);
        System.out.println(Arrays.toString(ints));
    }
}