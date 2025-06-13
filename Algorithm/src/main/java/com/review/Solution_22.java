package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", 0, 0, n);
        return ans;
    }

    private void dfs(List<String> ans, String s, int l, int r, int n) {
        if (l > n || r > n || l < r) return;
        if (l == n && r == n) {
            ans.add(s);
            return;
        }
        dfs(ans, s + "(", l + 1, r, n);
        dfs(ans, s + ")", l, r + 1, n);
    }
}
