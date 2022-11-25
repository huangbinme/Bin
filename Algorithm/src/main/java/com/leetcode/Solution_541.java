package com.leetcode;

public class Solution_541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i += 2 * k) {
            swap(sb, i, Math.min(i + k - 1, s.length() - 1));
        }
        return sb.toString();
    }

    private void swap(StringBuilder sb, int start, int end) {
        while (start < end) {
            char c = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, c);
            start++;
            end--;
        }
    }
}
