package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_5734 {
    public boolean checkIfPangram(String sentence) {
        if (sentence == null || "".equals(sentence.trim())) return false;
        Set<Character> stringSet = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            stringSet.add(sentence.charAt(i));
        }
        return stringSet.size() == 26;
    }
}
