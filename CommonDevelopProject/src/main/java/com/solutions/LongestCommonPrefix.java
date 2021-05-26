package com.solutions;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder result = new StringBuilder();
        int pointInString = 0;
        boolean noNeedToBreak = true;
        while (noNeedToBreak) {
            Set<Character> set = new HashSet<Character>();
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() - 1 < pointInString) {
                    noNeedToBreak = false;
                    break;
                }
                set.add(strs[i].charAt(pointInString));
            }
            if (!noNeedToBreak) {
                break;
            }
            if (set.size() == 1) {
                result.append(Character.valueOf(set.iterator().next()));
                pointInString++;
            } else {
                break;
            }
        }
        return result.toString();
    }

}
