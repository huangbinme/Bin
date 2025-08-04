package com.leetcode;

import java.util.*;

public class Solution_301 {

    Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int lr = 0, rr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lr++;
            } else if (s.charAt(i) == ')') {
                if (lr > 0) {
                    lr--;
                } else {
                    rr++;
                }
            }
        }
        dfs(s, lr, rr, 0);
        return ans.size() == 0 ? Arrays.asList("") : new ArrayList<>(ans);
    }

    private void dfs(String s, int lr, int rr, int start) {
        if (lr == 0 && rr == 0) {
            if (validate(s)) {
                ans.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) continue;
            if (s.charAt(i) == '(' && lr > 0) {
                String newS = s.substring(0, i) + s.substring(i + 1);
                dfs(newS, lr - 1, rr, i);
            }
            if (s.charAt(i) == ')' && rr > 0) {
                String newS = s.substring(0, i) + s.substring(i + 1);
                dfs(newS, lr, rr - 1, i);
            }
        }
    }

    private boolean validate(String s) {
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l > 0) {
                    l--;
                } else {
                    return false;
                }
            }
        }
        return l == 0;
    }

}
