package com.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder();
        Map<String, Boolean> map = new HashMap<>();
        return dfs(s, sb, wordDict, map);
    }

    private boolean dfs(String s, StringBuilder sb, List<String> wordDict, Map<String, Boolean> map) {
//        if (sb.length() > s.length() || !sb.toString().equals(s.substring(0, sb.length()))) return false;
        if (sb.length() > s.length() || !s.startsWith(sb.toString())) return false;
        if (s.length() == sb.length()) return true;
        for (int i = 0; i < wordDict.size(); i++) {
            int pre = sb.length();
            sb.append(wordDict.get(i));
            boolean re;
            String q = sb + "|" + wordDict.get(i);
            if (map.containsKey(q)) {
                re = map.get(q);
            } else {
                re = dfs(s, sb, wordDict, map);
            }
            map.put(q, re);
            sb.delete(pre, sb.length());
            if (re) return true;
        }
        return false;
    }
}
