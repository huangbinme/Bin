package com.leetcode;

public class Solution_443 {
    public int compress(char[] chars) {
        int count = 1;
        int point = 1;
        StringBuilder sb = new StringBuilder();
        while (point < chars.length) {
            if (chars[point] == chars[point - 1]) {
                count++;
            } else {
                sb.append(chars[point - 1]);
                if (count != 1) sb.append(count);
                count = 1;
            }
            point++;
        }
        sb.append(chars[chars.length - 1]);
        if (count != 1) sb.append(count);
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}
