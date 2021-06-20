package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_1239 {
    int max = 0;

    public int maxLength(List<String> arr) {
        List<Set<Character>> dfsList = new ArrayList<>();
        for (String s : arr) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
            if (set.size() == s.length()) dfsList.add(set);
        }
        Set<Character> dfsSet = new HashSet<>();
        for (int i = 0; i < dfsList.size(); i++) {
            dfs(dfsList, dfsSet, i);
        }
        return max;
    }

    private void dfs(List<Set<Character>> list, Set<Character> dfsSet, int index) {
        for (int i = index; i < list.size(); i++) {
            if (check(dfsSet, list.get(i))) continue;
            Set<Character> sub = list.get(i);
            dfsSet.addAll(sub);
            max = Math.max(max, dfsSet.size());
            dfs(list, dfsSet, i + 1);
            dfsSet.removeAll(sub);
        }
    }

    private boolean check(Set<Character> dfsSet, Set<Character> set) {
        for (Character c : set) {
            if (dfsSet.contains(c)) return true;
        }
        return false;
    }
}
