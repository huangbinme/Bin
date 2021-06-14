package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<Character>[] lists = new List[numRows];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
        int index = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            if (down && index != numRows - 1) {
                lists[index++].add(s.charAt(i));
            } else if (!down && index != 0) {
                lists[index--].add(s.charAt(i));
            } else if (down && index == numRows - 1) {
                lists[index--].add(s.charAt(i));
                down = false;
            } else {
                lists[index++].add(s.charAt(i));
                down = true;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Character> list : lists) {
            for (Character character : list) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }
}
