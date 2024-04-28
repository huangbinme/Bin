package com.leetcode;

public class Solution_1017 {
    public String baseNeg2(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (i % 2 == 1 && sb.charAt(i) == '1') {
                plus(sb, i + 1);
            }
        }
        return sb.reverse().toString();
    }

    private void plus(StringBuilder sb, int i) {
        if (sb.length() == i) {
            sb.append('1');
            return;
        }
        if (sb.charAt(i) == '0') {
            sb.setCharAt(i, '1');
            return;
        }
        sb.setCharAt(i, '0');
        plus(sb, i + 1);
    }
}
