package com.review;

public class Solution_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        boolean down = true;
        int line = 0;
        for (int i = 0; i < s.length(); i++) {
            if (stringBuilders[line] == null) stringBuilders[line] = new StringBuilder();
            stringBuilders[line].append(s.charAt(i));
            line += down ? 1 : -1;
            if (line == -1) {
                line += 2;
                down = true;
            } else if (line == numRows) {
                line -= 2;
                down = false;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stringBuilders.length; i++) {
            if (stringBuilders[i] != null) ans.append(stringBuilders[i].toString());
        }
        return ans.toString();
    }
}
