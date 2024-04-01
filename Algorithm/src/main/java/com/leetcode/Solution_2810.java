package com.leetcode;

public class Solution_2810 {
    public String finalString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                StringBuilder sb = new StringBuilder(s.substring(0, i));
                sb.reverse();
                s = i == s.length() - 1 ? sb.toString() : sb + s.substring(i);
            }
        }
        return s.replaceAll("i","");
    }
}
