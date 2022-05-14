package com.leetcode;

public class Solution_394 {
    public String decodeString(String s) {
        return dfs(0, s.length(), s);
    }

    private String dfs(int start, int end, String s) {
        if (end - start == 1) return String.valueOf(s.charAt(start));
        StringBuilder sb = new StringBuilder();
        int p = start;
        while (p < end) {
            if (s.charAt(p) >= 'a' && s.charAt(p) <= 'z') {
                sb.append(s.charAt(p++));
            } else {
                int[] bound = findBound(p, s);
                String repeat = dfs(bound[0] + 1, bound[1], s);
                int fre = Integer.parseInt(s.substring(p, bound[0]));
                for (int i = 0; i < fre; i++) {
                    sb.append(repeat);
                }
                p = bound[1] + 1;
            }
        }
        return sb.toString();
    }

    private int[] findBound(int start, String s) {
        int[] ans = new int[2];
        while (s.charAt(start) != '[') start++;
        ans[0] = start;
        int c = 1;
        start++;
        while (c != 0) {
            if (s.charAt(start) == '[') {
                c++;
            } else if (s.charAt(start) == ']') {
                c--;
            }
            start++;
        }
        ans[1] = start - 1;
        return ans;
    }
}
