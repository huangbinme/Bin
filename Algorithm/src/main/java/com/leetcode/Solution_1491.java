package com.leetcode;

public class Solution_1491 {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        for (int i : salary) {
            min = Math.min(min, i);
            max = Math.max(max, i);
            sum += i;
        }
        return ((double) sum - max - min) / (salary.length - 2);
    }
}
