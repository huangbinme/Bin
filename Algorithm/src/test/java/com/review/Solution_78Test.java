package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_78Test {

    @Test
    public void testSubsets() {
        Solution_78 solution78 = new Solution_78();
        System.out.println(solution78.subsets(new int[]{1,2,3}));
    }
}