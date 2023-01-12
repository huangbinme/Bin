package com.leetcode;

public class Solution_2283 {
    public boolean digitCount(String num) {
        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (count[i] != num.charAt(i) - '0') return false;
        }
        return true;
    }
}
˚