package com.leetcode;

public class Solution_1702 {
    public String maximumBinaryString(String binary) {
        int firstZero = binary.indexOf('0');
        if (firstZero == -1) return binary;
        int count = 0;
        for (int i = firstZero; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') count++;
        }
        int remainLength = binary.length() - firstZero;
        int appendLOne = remainLength - 1 - count;
        int appendROne = count;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firstZero + appendLOne; i++) {
            sb.append('1');
        }
        sb.append('0');
        for (int i = 0; i < appendROne; i++) {
            sb.append('1');
        }
        return sb.toString();
    }
}
