package com.leetcode;

public class Solution {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder(n);
        if (n.startsWith("-")) {
            int target = sb.length();
            for (int i = 1; i < sb.length(); i++) {
                if (Character.digit(sb.charAt(i),10) > x) {
                    target = i;
                    break;
                }
            }
            sb.insert(target, x);
        } else {
            int target = sb.length();
            for (int i = 0; i < sb.length(); i++) {
                if (Character.digit(sb.charAt(i),10) < x) {
                    target = i;
                    break;
                }
            }
            sb.insert(target, x);
        }
        return sb.toString();
    }
}
