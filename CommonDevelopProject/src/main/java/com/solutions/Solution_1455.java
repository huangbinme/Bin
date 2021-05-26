package com.solutions;

public class Solution_1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int l = searchWord.length();
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() >= l && strings[i].substring(0, l).equals(searchWord)) {
                return i;
            }
        }
        return -1;
    }
}
