package com.leetcode;

public class Solution_344 {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            swap(l, r, s);
            l++;
            r--;
        }
    }

    private void swap(int i, int j, char[] chars) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
