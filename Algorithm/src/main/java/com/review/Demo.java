package com.review;

public class Demo {
    public int solution1(String s) {
        //0100 - 0010 0001 0000
        int firstOne = 0;
        while (firstOne < s.length()) {
            if (s.charAt(firstOne) == '0') {
                firstOne++;
            } else {
                break;
            }
        }
        if (firstOne == s.length()) return 0;
        StringBuilder sb = new StringBuilder(s.substring(firstOne));
        int ans = 0;
        while (sb.length() != 0) {
            char last = sb.charAt(sb.length() - 1);
            if (last == '0') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                if (sb.length() == 1) {
                    ans++;
                    break;
                } else {
                    sb.setCharAt(sb.length() - 1, '0');
                }
            }
            ans++;
        }
        return ans;
    }
}
