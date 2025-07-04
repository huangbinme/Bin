package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> save = new ArrayList<>();
        dfs(ans, save, s, 0);
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> save, String s, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(save));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (check(s, start, i)) {
                save.add(s.substring(start, i + 1));
                dfs(ans, save, s, i + 1);
                save.remove(save.size() - 1);
            }
        }
    }

    private boolean check(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
