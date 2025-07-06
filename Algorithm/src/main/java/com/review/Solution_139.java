package com.review;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_139 {

    Set<String> unmatch = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict);
    }

    private boolean dfs(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) return true;
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            boolean startsWith = s.startsWith(word);
            boolean ans = false;
            if (startsWith && s.length() >= word.length()) {
                String substring = s.substring(word.length());
                if(!unmatch.contains(substring)){
                    ans = dfs(substring, wordDict);
                    if(!ans) unmatch.add(substring);
                }
            }
            if (ans) return true;
        }
        return false;
    }
}
