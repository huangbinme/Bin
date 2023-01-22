package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_131 {
    public List<List<String>> partition(String s) {
        return dfs(s, 0, s.length());
    }

    private List<List<String>> dfs(String s, int start, int end) {
        if (start == end) return Collections.emptyList();
        List<List<String>> ans = new ArrayList<>();
        for (int i = start + 1; i < end; i++) {
            if (validate(s, start, i)) {
                String head = s.substring(start, i);
                List<List<String>> sub = dfs(s, i, end);
                for (List<String> strings : sub) {
                    strings.add(0, head);
                    ans.add(new ArrayList<>(strings));
                }
            }
        }
        if (validate(s, start, end)) {
            List<String> list = new ArrayList<>();
            list.add(s.substring(start, end));
            ans.add(list);
        }
        return ans;
    }

    private boolean validate(String s, int start, int end) {
        if (end - start == 1) return true;
        end--;
        while (end - start > 0) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
