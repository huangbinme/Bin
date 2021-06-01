package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_525Test {

    @Test
    public void testFindMaxLength() {
        Solution_525 s = new Solution_525();
        System.out.println(s.findMaxLength(new int[]{0,0,1,0,1,1}));
    }
}