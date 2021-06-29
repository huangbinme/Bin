package com.leetcode;

public class Solution_168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            stringBuilder.insert(0, (char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return stringBuilder.toString();
    }
}
