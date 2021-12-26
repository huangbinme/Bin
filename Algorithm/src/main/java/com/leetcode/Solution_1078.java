package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_1078 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        String[] strings = text.split(" ");
        for (int i = 0; i < strings.length - 2; i++) {
            if (strings[i].equals(first) && strings[i + 1].equals(second)) {
                ans.add(strings[i + 2]);
            }
        }
        return ans.toArray(new String[0]);
    }
}
