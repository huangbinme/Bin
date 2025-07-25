package com.interview.amazon;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_4Test {

    @Test
    public void testNthSuperUglyNumber() {
        Solution_4 solution4 = new Solution_4();
        System.out.println(Solution_4.missingDigits("9",2,3));
    }

    @Test
    public void testNthSuperUglyNumber2() {
        int i = 2, j = 3, sum = 0;
        for (int k = 0; k < 100; k++) {
            sum += i;
            System.out.println(sum % 10);
            sum += j;
            System.out.println(sum % 10);
        }
    }

    @Test
    public void testInit() {
        System.out.println(Solution_4.get(2,3,6,2));
    }

    @Test
    public void testGenerateMinSequence() {
        Solution_4 s = new Solution_4();
        System.out.println(Solution_4.get(2,3,6,1));
    }
}