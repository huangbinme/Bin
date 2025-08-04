package com.interview.paypay;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_3Test {

    @Test
    public void testFindMinimumPrice() {
        Solution_3 solution3 = new Solution_3();
        System.out.println(solution3.findMinimumPrice(new int[]{2,4},2));
    }
}