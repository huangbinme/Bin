package com.leetcode;

public class Solution_38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j <= str.length(); j++) {
                if (j == str.length()) {
                    sb.append((char) ('0' + count));
                    sb.append(str.charAt(j - 1));
                } else {
                    if (str.charAt(j) != str.charAt(j - 1)) {
                        sb.append((char) ('0' + count));
                        sb.append(str.charAt(j - 1));
                        count = 1;
                    } else {
                        count++;
                    }
                }
            }
            str = sb.toString();
        }
        return str;
    }
}
