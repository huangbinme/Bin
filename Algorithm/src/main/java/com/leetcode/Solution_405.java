package com.leetcode;

public class Solution_405 {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        long numL = num;
        if (numL < 0) numL = (long) (Math.pow(2, 32) + numL);
        while (numL != 0) {
            long cur = numL % 16;
            numL /= 16;
            char curChar;
            if (cur < 10) {
                curChar = (char) ('0' + cur);
            } else {
                curChar = (char) ('a' + cur - 10);
            }
            sb.insert(0, curChar);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
