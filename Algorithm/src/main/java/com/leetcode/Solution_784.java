package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_784 {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(S);
        List<Integer> charIndex = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) if (!Character.isDigit(S.charAt(i))) charIndex.add(i);
        dfs(stringBuilder, charIndex, result, 0);
        return result;
    }

    private void dfs(StringBuilder stringBuilder, List<Integer> charIndex, List<String> result, int adjustCount) {
        if (adjustCount == charIndex.size()) {
            result.add(stringBuilder.toString());
            return;
        }
        dfs(stringBuilder, charIndex, result, adjustCount + 1);
        reverseChar(stringBuilder, charIndex.get(adjustCount));
        dfs(stringBuilder, charIndex, result, adjustCount + 1);
    }

    private StringBuilder reverseChar(StringBuilder stringBuilder, int index) {
        stringBuilder.setCharAt(index, changeCase(stringBuilder.charAt(index)));
        return stringBuilder;
    }

    private char changeCase(char c) {
        return Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
    }
}
