package com.interview.paypay;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_5Test {

    @Test
    public void testCalculateChange() {
        Solution_5 solution5 = new Solution_5();
        System.out.println(solution5.calculateChange(240.0F, 500.0F));
    }
}