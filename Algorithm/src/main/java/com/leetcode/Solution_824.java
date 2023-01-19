package com.leetcode;

public class Solution_824 {
    public String toGoatLatin(String sentence) {
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder("a");
        int l = 0, r = 0;
        while (r <= sentence.length()) {
            while (r < sentence.length() && sentence.charAt(r) != ' ') r++;
            if (isVowel(sentence.charAt(l))) {
                ans.append(sentence, l, r).append("ma").append(sb).append(" ");
            } else {
                ans.append(sentence, l + 1, r).append(sentence.charAt(l)).append("ma").append(sb).append(" ");
            }
            sb.append("a");
            r++;
            l = r;
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}
