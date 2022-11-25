package com.leetcode;

public class Solution_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] note = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            note[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            note[ransomNote.charAt(i) - 'a']--;
            if (note[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
