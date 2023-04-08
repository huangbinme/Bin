package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_2609 {
    public int findTheLongestBalancedSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        int start = s.charAt(0) == '0' ? 0 : 1;
        int ans = 0;
        for (int i = start; i < list.size() - 1; i += 2) {
            ans = Math.max(ans, Math.min(list.get(i), list.get(i + 1)) * 2);
        }
        return ans;
    }
}
