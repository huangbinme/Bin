package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_238Test {

    @Test
    public void testProductExceptSelf() {
        Solution_238 solution238= new Solution_238();
        solution238.productExceptSelf(new int[]{-1,1,0,-3,3});
    }
}