package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return ans;
        StringBuilder sb = new StringBuilder(s);
        dfs(sb, ans, 0, -1);
        return new ArrayList<>(ans);
    }

    private void dfs(StringBuilder sb, List<String> ans, int pCount, int pre) {
        if (pCount == 3) {
            if (isValidate(sb.toString())) ans.add(sb.toString());
            return;
        }
        for (int i = pre + 2; i <= pre + 5 && i < sb.length(); i++) {
            sb.insert(i, '.');
            dfs(sb, ans, pCount + 1, i);
            sb.deleteCharAt(i);
        }
    }

    private boolean isValidate(String s) {
        String[] strings = s.split("\\.");
        for (int i = 0; i < strings.length; i++) {
            String s1 = strings[i];
            if (s1.length() == 0) return false;
            if (s1.charAt(0) == '0' && s1.length() > 1) return false;
            int n = Integer.parseInt(s1);
            if (!(n >= 0 && n <= 255)) return false;
        }
        return true;
    }
}
