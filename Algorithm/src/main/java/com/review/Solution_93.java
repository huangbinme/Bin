package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return ans;
        List<String> save = new ArrayList<>();
        dfs(ans, save, s, 0);
        return ans;
    }

    private void dfs(List<String> ans, List<String> save, String s, int start) {
        if (save.size() == 4 || start >= s.length()) {
            if (save.size() == 4 && start >= s.length()) {
                ans.add(String.join(".", save));
            }
            return;
        }
        save.add(s.substring(start, start + 1));
        dfs(ans, save, s, start + 1);
        save.remove(save.size() - 1);

        if (start + 2 <= s.length()) {
            String sub = s.substring(start, start + 2);
            if (check(sub)) {
                save.add(sub);
                dfs(ans, save, s, start + 2);
                save.remove(save.size() - 1);
            }
        }

        if (start + 3 <= s.length()) {
            String sub2 = s.substring(start, start + 3);
            if (check(sub2)) {
                save.add(sub2);
                dfs(ans, save, s, start + 3);
                save.remove(save.size() - 1);
            }
        }
    }

    private boolean check(String s) {
        if (s.length() > 3) return false;
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int v = Integer.parseInt(s);
        return 0 <= v && v <= 255;
    }
}
