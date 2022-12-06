package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_809 {
    public int expressiveWords(String s, String[] words) {
        List<int[]> list = generate(s);
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            ans += check(list, words[i]);
        }
        return ans;
    }

    private int check(List<int[]> base, String word) {
        List<int[]> wordList = generate(word);
        if (wordList.size() != base.size()) return 0;
        for (int i = 0; i < wordList.size(); i++) {
            int[] baseObj = base.get(i);
            int[] wordObj = wordList.get(i);
            if (baseObj[0] != wordObj[0] || !(baseObj[1] == wordObj[1] || baseObj[1] >= 3) || wordObj[1] > baseObj[1]) {
                return 0;
            }
        }
        return 1;
    }

    private List<int[]> generate(String s) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (list.isEmpty() || list.get(list.size() - 1)[0] != c - 'a') {
                list.add(new int[]{c - 'a', 1});
            } else {
                list.get(list.size() - 1)[1]++;
            }
        }
        return list;
    }
}
