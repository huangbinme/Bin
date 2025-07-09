package com.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_187 {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String subStr = s.substring(i, i + 10);
            map.merge(subStr, 1, Integer::sum);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}
