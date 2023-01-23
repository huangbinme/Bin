package com.leetcode;

public class Solution_2303 {
    public double calculateTax(int[][] brackets, int income) {
        double sum = 0;
        for (int i = 0; i < brackets.length; i++) {
            int pre = i == 0 ? 0 : brackets[i - 1][0];
            sum += (Math.min(income, brackets[i][0]) - pre) * brackets[i][1] / 100d;
            if (income <= brackets[i][0]) break;
        }
        return sum;
    }
}
