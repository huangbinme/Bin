package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_3001Test {

    @Test
    public void testMinMovesToCaptureTheQueen() {
        Solution_3001 solution3001 = new Solution_3001();
        System.out.println(solution3001.minMovesToCaptureTheQueen(1,1,2,1,3,1));
    }
}