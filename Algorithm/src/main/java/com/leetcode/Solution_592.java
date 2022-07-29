package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_592 {
    public String fractionAddition(String expression) {
        expression = expression.charAt(0) == '-' ? expression : "+" + expression;
        List<String> list = new ArrayList<>();
        int l = 0, r = 1;
        while (r < expression.length()) {
            if (expression.charAt(r) == '+' || expression.charAt(r) == '-') {
                list.add(expression.substring(l, r));
                l = r;
                r++;
            } else {
                r++;
            }
        }
        list.add(expression.substring(l, r));
        String ans = "+0/1";
        for (int i = 0; i < list.size(); i++) {
            ans = add(ans, list.get(i));
        }
        return ans.charAt(0) == '+' ? ans.substring(1) : ans;
    }

    private String add(String s1, String s2) {
        int s1Slid = s1.indexOf('/');
        int s2Slid = s2.indexOf('/');
        int x1 = Integer.parseInt(s1.substring(0, s1Slid)), y1 = Integer.parseInt(s1.substring(s1Slid + 1));
        int x2 = Integer.parseInt(s2.substring(0, s2Slid)), y2 = Integer.parseInt(s2.substring(s2Slid + 1));
        int up = x1 * y2 + x2 * y1;
        int down = y1 * y2;
        String ans = up >= 0 ? "+" : "-";
        up = Math.abs(up);
        int target = Math.min(up, down);
        if (up == 0) return "+0/1";
        while (true) {
            if (up % target == 0 && down % target == 0) {
                break;
            } else {
                target--;
            }
        }
        up /= target;
        down /= target;
        return ans + up + "/" + down;
    }
}
