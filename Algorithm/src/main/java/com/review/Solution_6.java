package com.review;

public class Solution_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); i++) {
            int k = numRows * 2 - 2, j = i % k;
            int location = j < numRows ? j : (k - (j + 1) + 1);
            sb[location].append(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < sb.length; i++) {
            ans.append(sb[i].toString());
        }
        return ans.toString();
    }
}
