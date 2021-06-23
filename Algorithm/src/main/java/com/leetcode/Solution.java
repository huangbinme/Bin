package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String[] permutation(String s) {
        String[] strings = s.split("");
        Arrays.sort(strings);
        s = String.join("", strings);
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visit = new boolean[s.length()];
        dfs(list, visit, sb, s, 0);
        String[] ans = new String[list.size()];
        return list.toArray(ans);
    }

    private void dfs(List<String> list, boolean[] visit, StringBuilder sb, String s, int index) {
        if (index == s.length()) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visit[i] || (i > 0 && !visit[i - 1] && s.charAt(i) == s.charAt(i - 1))) continue;
            sb.append(s.charAt(i));
            visit[i] = true;
            dfs(list, visit, sb, s, index + 1);
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
        }
    }
}
