package com.leetcode.offer;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_33Test {

    @Test
    public void testVerifyPostorder() {
        Solution_33 s = new Solution_33();
        s.verifyPostorder(new int[]{1,2,5,10,6,9,4,3});
    }
}