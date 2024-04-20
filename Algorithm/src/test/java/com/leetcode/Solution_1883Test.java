package com.leetcode;

import org.testng.annotations.Test;

public class Solution_1883Test {

    @Test
    public void testMinSkips() {
        Solution_1883 solution1883 = new Solution_1883();
        System.out.println(solution1883.minSkips(new int[]{7, 3, 3, 5}, 2, 10));
    }

    @Test
    public void testMinSkip2() {
        Solution_1883 solution1883 = new Solution_1883();
        System.out.println(solution1883.minSkips(new int[]{1, 3, 2}, 4, 2));
    }

    public static void main(String[] args) {
        double i1 = 1.0 / 3.0;
        double i2 = 1.0 / 3.0;
        double i3 = 1.0 / 3.0;
        System.out.println(i1 + i2 + i3);
    }
}