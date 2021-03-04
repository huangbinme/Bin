package com.solutions;

public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) return 0;
        int maxNonDuplicateStrLength = 1;
        String[] strings = s.split("");
        int low = 0;
        int high = 0;
        while (low < strings.length && high < strings.length) {
            if(low==high){
                high++;
                continue;
            }
            int check = nonDuplicate(strings, low, high-1, strings[high]);
            if (check<0) {
                maxNonDuplicateStrLength = Math.max(maxNonDuplicateStrLength, high - low + 1);
                high++;
            } else {
                low = check+1;
            }
        }
        return maxNonDuplicateStrLength;
    }

    public int nonDuplicate(String[] strings, int i, int j, String s) {
        for (int k = i; k <= j; k++) {
            if (strings[k].equals(s)) return k;
        }
        return -1;
    }
}
