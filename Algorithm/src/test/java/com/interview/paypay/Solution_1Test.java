package com.interview.paypay;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_1Test {

    @Test
    public void testSumConsecutiveIdenticalDigits() {
        Solution_1 solution1 = new Solution_1();
        System.out.println(solution1.sumConsecutiveIdenticalDigits("99823"));
        System.out.println(solution1.sumConsecutiveIdenticalDigits("11199823"));
    }
}