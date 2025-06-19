package com.review;

public class Solution_38 {

    public String countAndSay(int n) {
        return countAndSay(n, "1");
    }

    private String countAndSay(int n, String s) {
        if (n == 1) return s;
        int p = 0;
        String next = "";
        while (p < s.length()) {
            int start = p;
            char c = s.charAt(p);
            while (p < s.length() && s.charAt(p) == c) p++;
            next = next + (p - start) + c;
        }
        return countAndSay(n - 1, next);
    }

}
