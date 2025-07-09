package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_165Test {

    @Test
    public void testCompareVersion() {
        Solution_165 solution165 = new Solution_165();
        System.out.println(solution165.compareVersion("1.2","1.10"));
    }
}