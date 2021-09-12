package com.leetcode;

public class Solution_1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }
        long left = k % sum;
        for (int i = 0; i < chalk.length; i++) {
            if (left < chalk[i]) {
                return i;
            } else {
                left -= chalk[i];
            }
        }
        return -1;
    }
}
