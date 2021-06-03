package com.leetcode.offer;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_38 {
    public String[] permutation(String s) {
        Deque<String> deque = Arrays.stream(s.split(""))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toCollection(LinkedList::new));
        List<String> ans = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = new String[ans.size()];
        dfs(deque, ans, stringBuilder, s);
        return ans.toArray(strings);
    }

    private void dfs(Deque<String> deque, List<String> ans, StringBuilder stringBuilder, String s) {
        if (stringBuilder.length() == s.length()) {
            ans.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < deque.size(); i++) {

        }
    }
}
