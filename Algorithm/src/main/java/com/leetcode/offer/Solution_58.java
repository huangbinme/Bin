package com.leetcode.offer;

public class Solution_58 {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = s.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            String str = strings[i].trim();
            if (!"".equals(str)) {
                stringBuilder.append(str + " ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
