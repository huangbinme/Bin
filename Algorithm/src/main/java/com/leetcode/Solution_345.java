package com.leetcode;

public class Solution_345 {
    public String reverseVowels(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!validate(stringBuilder.charAt(left)) && left < right) left++;
            while (!validate(stringBuilder.charAt(right)) && left < right) right--;
            if (left >= right) break;
            swap(stringBuilder, left++, right--);
        }
        return stringBuilder.toString();
    }

    private void swap(StringBuilder sb, int i, int j) {
        char c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
    }

    private boolean validate(char s) {
        return 'a' == Character.toLowerCase(s) || 'e' == Character.toLowerCase(s) || 'i' == Character.toLowerCase(s) || 'o' == Character.toLowerCase(s) || 'u' == Character.toLowerCase(s);
    }
}
