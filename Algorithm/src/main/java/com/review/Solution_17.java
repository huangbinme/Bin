package com.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_17 {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        Map<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        String[][] strings = new String[digits.length()][];
        for (int i = 0; i < digits.length(); i++) {
            strings[i] = map.get(digits.charAt(i));
        }
        List<String> ans = new ArrayList<>();
        dfs(strings, ans, "", 0);
        return ans;
    }

    private void dfs(String[][] strings, List<String> ans, String s, int i) {
        if (i == strings.length - 1) {
            for (int j = 0; j < strings[i].length; j++) {
                ans.add(s + strings[i][j]);
            }
            return;
        }
        for (int k = 0; k < strings[i].length; k++) {
            dfs(strings, ans, s + strings[i][k], i + 1);
        }
    }
}
