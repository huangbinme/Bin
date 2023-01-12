package com.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            List<String> strings = knowledge.get(i);
            map.put(strings.get(0), strings.get(1));
        }
        StringBuilder sb = new StringBuilder(s);
        int p = 0;
        while (p < sb.length()) {
            if (sb.charAt(p) == '(') {
                int findNext = findNext(sb, p);
                String key = sb.substring(p + 1, findNext), value = map.getOrDefault(key, "?");
                sb.replace(p, findNext + 1, value);
                p += value.length();
            } else {
                p++;
            }
        }
        return sb.toString();
    }

    private int findNext(StringBuilder sb, int p) {
        while (sb.charAt(p) != ')') p++;
        return p;
    }
}
