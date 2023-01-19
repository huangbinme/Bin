package com.leetcode;

public class Solution_791 {
    public String customSortString(String order, String s) {
        StringBuilder ans = new StringBuilder();
        int[] show = new int[26];
        for (int i = 0; i < s.length(); i++) {
            show[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < order.length(); i++) {
            int index = order.charAt(i) - 'a';
            while (show[index] != 0) {
                show[index]--;
                ans.append((char) ('a' + index));
            }
        }
        for (int i = 0; i < show.length; i++) {
            while (show[i] != 0) {
                show[i]--;
                ans.append((char) ('a' + i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println((char) ('a' + 1));
    }
}
