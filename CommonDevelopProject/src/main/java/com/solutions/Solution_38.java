package com.solutions;

public class Solution_38 {
    public String countAndSay(int n) {
        String dp = "1";
        for (int i = 0; i < n-1; i++){
            dp = set(dp);
        }
        return dp;
    }

    private String set(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        char comparingChar = s.charAt(0);
        int comparingCharCount = 0;
        while (index < s.length()) {
            while (index < s.length() && s.charAt(index) == comparingChar) {
                index++;
                comparingCharCount++;
            }
            stringBuilder.append(comparingCharCount).append(comparingChar);
            if(index < s.length()){
                comparingChar = s.charAt(index);
                comparingCharCount = 0;
            }
        }
        return stringBuilder.toString();
    }
}
