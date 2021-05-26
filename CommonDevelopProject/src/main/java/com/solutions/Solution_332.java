package com.solutions;

import java.util.List;

public class Solution_332 {
    private static boolean isSmaller(String s1, String s2) {
        if (s1.charAt(0) < s2.charAt(0)) return true;
        if (s1.charAt(0) > s2.charAt(0)) return false;
        if (s1.charAt(1) < s2.charAt(1)) return true;
        if (s1.charAt(1) > s2.charAt(1)) return false;
        if (s1.charAt(2) < s2.charAt(2)) return true;
        return s1.charAt(2) <= s2.charAt(2);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        return null;
    }
}
