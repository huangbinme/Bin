package com.leetcode;

public class Solution_1736 {
    public String maximumTime(String time) {
        StringBuilder s = new StringBuilder();
        s.append(time.charAt(0) == '?' ? ((time.charAt(1) - '0' < 4 || time.charAt(1) == '?') ? '2' : '1') : time.charAt(0));
        s.append(time.charAt(1) == '?' ? (s.charAt(0) == '2' ? '3' : '9') : time.charAt(1));
        s.append(":");
        s.append(time.charAt(3) == '?' ? '5' : time.charAt(3));
        s.append(time.charAt(4) == '?' ? '9' : time.charAt(4));
        return s.toString();
    }
}
